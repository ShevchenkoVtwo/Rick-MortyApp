package com.shevchenkovtwo.rickmortyapp

import com.shevchenkovtwo.rickmortyapp.model.Character
import com.shevchenkovtwo.rickmortyapp.model.Episode
import com.shevchenkovtwo.rickmortyapp.model.Location


object AppConstants {
    const val baseUri = "https://rickandmortyapi.com/api/"
    const val TAG = "-------------"
    var characterSelected: Character? = null
    var locationSelected: Location? = null
    var episodeSelected: Episode? = null
    val statusAlive = "Alive"
    val statusDead = "Dead"
    val statusUnknown = "unknown"
}