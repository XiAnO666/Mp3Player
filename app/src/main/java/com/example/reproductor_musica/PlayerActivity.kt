package com.example.reproductor_musica

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.reproductor_musica.databinding.ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayerBinding
    private lateinit var mediaPlayer: MediaPlayer
    private val handler = Handler(Looper.getMainLooper())
    private val updateSeekBar = object : Runnable {
        override fun run() {
            if (mediaPlayer.isPlaying) {  // Comprobar si el MediaPlayer está reproduciendo música
                binding.seekBar.progress = mediaPlayer.currentPosition
                handler.postDelayed(this, 1000)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar la información de la canción
        val songMp3 = intent.getIntExtra("songMp3", -1)
        val albumCoverName = intent.getStringExtra("albumCover")
        val songTitle = intent.getStringExtra("songTitle")
        val bandName = intent.getStringExtra("bandName")

        // Configurar las vistas con la información de la canción
        val albumCoverId = resources.getIdentifier(albumCoverName, "drawable", packageName)
        binding.albumCover.setImageResource(albumCoverId)
        binding.songTitle.text = songTitle
        binding.bandName.text = bandName

        // Configurar el OnClickListener para el botón de retroceso
        binding.backButton.setOnClickListener {
            finish()  // Esto cerrará PlayerActivity y te llevará de vuelta a MainActivity
        }

        // Inicializar el reproductor de música
        mediaPlayer = MediaPlayer.create(this, songMp3)

        // Configurar los OnClickListener para los botones de play, pause y stop
        binding.playButton.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                handler.postDelayed(updateSeekBar, 1000)  // Comenzar a actualizar la SeekBar cuando se inicia la música
            }
        }

        binding.pauseButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                handler.removeCallbacks(updateSeekBar)  // Dejar de actualizar la SeekBar cuando se pausa la música
            }
        }

        binding.stopButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
                mediaPlayer.prepare()  // Preparar el reproductor para la próxima vez que se presione play
                handler.removeCallbacks(updateSeekBar)  // Dejar de actualizar la SeekBar cuando se detiene la música
            }
        }

        // Configurar la SeekBar
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Opcional: puedes agregar código aquí que se ejecute cuando el usuario comienza a mover la SeekBar.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Opcional: puedes agregar código aquí que se ejecute cuando el usuario deja de mover la SeekBar.
            }
        })

        // Configurar la duración máxima de la SeekBar
        mediaPlayer.setOnPreparedListener {
            binding.seekBar.max = mediaPlayer.duration
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(updateSeekBar)  // Eliminar las devoluciones de llamada al Handler cuando la actividad se destruya
        mediaPlayer.release()  // Liberar los recursos del reproductor de música cuando la actividad se destruya
    }
}
