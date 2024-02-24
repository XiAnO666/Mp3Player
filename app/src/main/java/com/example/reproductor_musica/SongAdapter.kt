package com.example.reproductor_musica

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SongAdapter (private val context: Context, private val songList: List<Song>): RecyclerView.Adapter<SongViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SongViewHolder(layoutInflater.inflate(R.layout.activity_songlist, parent, false))

    }

    override fun getItemCount(): Int {
       return songList.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val item = songList[position]
        holder.bind(item, context)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlayerActivity::class.java)
            intent.putExtra("albumCover", context.resources.getResourceEntryName(item.image))  // Pasar el nombre del recurso de la imagen
            intent.putExtra("songTitle", item.songTitle)  // Pasar el título de la canción
            intent.putExtra("bandName", item.bandName)  // Pasar el nombre de la banda
            intent.putExtra("songMp3", item.songMp3)  //Pasar el nombre de la canción
            holder.itemView.context.startActivity(intent)
        }
    }
}