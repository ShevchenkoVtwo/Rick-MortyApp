package com.shevchenkovtwo.rickmortyapp.model

import com.squareup.moshi.Json


data class Location(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "dimension")
    val dimension: String,
    @Json(name = "created")
    val created: String
)