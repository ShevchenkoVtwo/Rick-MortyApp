package com.shevchenkovtwo.rickmortyapp.responses

import com.google.gson.annotations.SerializedName
import com.shevchenkovtwo.rickmortyapp.model.Location

data class LocationsResponse(
    @SerializedName("results")
    val locations: List<Location>
)