package com.shevchenkovtwo.rickmortyapp.responses

import com.google.gson.annotations.SerializedName
import com.shevchenkovtwo.rickmortyapp.model.Character

data class CharactersResponse(
    @SerializedName("results")
    val characters: List<Character>
)