package com.shevchenkovtwo.rickmortyapp

import com.shevchenkovtwo.rickmortyapp.model.Character

object AppConstants {
    const val baseUri = "https://rickandmortyapi.com/api/"
    const val TAG = "-------------"
    var characterSelected: Character? = null
    var pageCounter = 1
}