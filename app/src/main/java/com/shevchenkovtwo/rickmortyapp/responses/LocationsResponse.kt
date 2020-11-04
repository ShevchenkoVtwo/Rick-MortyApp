package com.shevchenkovtwo.rickmortyapp.responses

import com.shevchenkovtwo.rickmortyapp.model.Location
import com.squareup.moshi.Json


data class LocationsResponse(
    @Json(name = "results")
    val locations: List<Location>
)