package com.shevchenkovtwo.rickmortyapp.common

import com.shevchenkovtwo.rickmortyapp.data.database.model.Character
import com.shevchenkovtwo.rickmortyapp.data.database.model.Episode
import com.shevchenkovtwo.rickmortyapp.data.database.model.Location


object AppConstants {
    const val baseUri = "https://rickandmortyapi.com/api/"
    var characterSelected: Character? = null
    var locationSelected: Location? = null
    var episodeSelected: Episode? = null
    const val statusAlive = "Alive"
    const val statusDead = "Dead"
    const val statusUnknown = "unknown"
}