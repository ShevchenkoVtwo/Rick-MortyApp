package com.shevchenkovtwo.rickmortyapp.model

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("results")
    val characters:List<Character>)