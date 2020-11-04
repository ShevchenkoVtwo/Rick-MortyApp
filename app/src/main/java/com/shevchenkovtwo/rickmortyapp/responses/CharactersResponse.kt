package com.shevchenkovtwo.rickmortyapp.responses

import com.shevchenkovtwo.rickmortyapp.model.Character
import com.squareup.moshi.Json


data class CharactersResponse(
    @Json(name = "results")
    val characters: List<Character>
)