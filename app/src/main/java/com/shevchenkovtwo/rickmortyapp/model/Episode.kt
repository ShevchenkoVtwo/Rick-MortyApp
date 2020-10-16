package com.shevchenkovtwo.rickmortyapp.model

import com.google.gson.annotations.SerializedName

data class Episode(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episode")
    val code: String,
    @SerializedName("created")
    val created: String
)