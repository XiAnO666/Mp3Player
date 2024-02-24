package com.example.reproductor_musica

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reproductor_musica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



        private lateinit var binding: ActivityMainBinding
        private lateinit var adapter: SongAdapter
        private val songList = listOf<Song>(
            Song(R.raw.sleepnowinthefire, R.drawable.ratm ,"Sleep now in the fire" , "Rage Against The Machine"),
            Song(R.raw.allmylife, R.drawable.foofighters, "All my life", "Foo Fighters"),
            Song(R.raw.aquickdeathintexas, R.drawable.clutch, "A quick death in Texas", "Clutch"),
            Song(R.raw.bogusoperandi, R.drawable.thehives, "Bogus Operandi", "The Hives"),
            Song(R.raw.callmelittlesunshine, R.drawable.ghost, "Call me little sunshine", "Ghost"),
            Song(R.raw.clayman, R.drawable.inflames, "Clayman", "In Flames"),
            Song(R.raw.dancemacabre, R.drawable.ghost, "Dance Macabre", "Ghost"),
            Song(R.raw.doomsdaymachine, R.drawable.kadavar, "Doomsday Machine", "Kadavar"),
            Song(R.raw.everlong, R.drawable.foofighters, "Everlong", "Foo Fighters"),
            Song(R.raw.firebirds, R.drawable.clutch, "Firebirds!", "Clutch"),
            Song(R.raw.gifthorse, R.drawable.idles, "Gift Horse", "Idles"),
            Song(R.raw.kaiserion, R.drawable.ghost, "Kaiserion", "Ghost"),
            Song(R.raw.kittysucker, R.drawable.frankcarterandtherattlesnakes, "Kitty sucker", "Frank Carter And The Rattlesnakes"),
            Song(R.raw.learntofly, R.drawable.foofighters, "Learn to fly", "Foo Fighters"),
            Song(R.raw.lifeeternal, R.drawable.ghost, "Life Eternal", "Ghost"),
            Song(R.raw.littlesister, R.drawable.queensofthestoneage, "Little Sister", "Queens Of The Stone Age"),
            Song(R.raw.nowyouvegotsomethingtodiefor, R.drawable.lambofgod, "Now You've got something to die for", "Lamb Of God"),
            Song(R.raw.onlyfortheweak, R.drawable.inflames, "Only for the weak", "In Flames"),
            Song(R.raw.pinballmap, R.drawable.inflames, "Pinball map", "In Flames"),
            Song(R.raw.sharpentheguillotine, R.drawable.angelusapatrida, "Sharpen the guillotine", "Angelus Apatrida"),
            Song(R.raw.sleepnowinthefire, R.drawable.ratm, "Sleep now in the fire", "Rage Against The Machine"),
            Song(R.raw.steambreather, R.drawable.mastodon, "Steambreather", "Mastodon"),
            Song(R.raw.teadrinker, R.drawable.mastodon, "Tea drinker", "Mastodon"),
            Song(R.raw.theoldman, R.drawable.kadavar, "The old man", "Kadavar"),
            Song(R.raw.threessevens, R.drawable.queensofthestoneage, "3's 7's", "Queens Of The Stone Age"),
            Song(R.raw.ticktickboom, R.drawable.thehives, "Tick Tick Boom", "The Hives"),
            Song(R.raw.vampires, R.drawable.frankcarterandtherattlesnakes, "Vampires", "Frank Carter And The Rattlesnakes"),
            Song(R.raw.wildflowers, R.drawable.frankcarterandtherattlesnakes, "Wild flowers", "Frank Carter And The Rattlesnakes"),
            Song(R.raw.wontbelong, R.drawable.thehives, "Won't Belong", "The Hives")
        )
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            initRecyclerView()
        }
        private fun initRecyclerView(){
            adapter = SongAdapter(this, songList)
            binding.rvSong.layoutManager = LinearLayoutManager(this)
            binding.rvSong.adapter = adapter
        }
}