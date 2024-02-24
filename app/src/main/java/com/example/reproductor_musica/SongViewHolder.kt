package com.example.reproductor_musica

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.reproductor_musica.databinding.ActivitySonglistBinding

class SongViewHolder(view:View): RecyclerView.ViewHolder(view) {

    private val binding = ActivitySonglistBinding.bind(view)

    fun bind(song: Song, context: Context){
        binding.albumCover.setImageResource(song.image)
        binding.songTitle.text = song.songTitle
        binding.bandName.text = song.bandName
    }
}