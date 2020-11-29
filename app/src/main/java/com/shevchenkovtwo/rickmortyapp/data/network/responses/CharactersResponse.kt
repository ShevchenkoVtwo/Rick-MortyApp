package com.shevchenkovtwo.rickmortyapp.data.network.responses

import com.shevchenkovtwo.rickmortyapp.data.database.model.Character
import com.squareup.moshi.Json


data class CharactersResponse(
    @Json(name = "results")
    val characters: List<Character>
)