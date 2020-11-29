package com.shevchenkovtwo.rickmortyapp.data.network.responses

import com.shevchenkovtwo.rickmortyapp.data.database.model.Location
import com.squareup.moshi.Json


data class LocationsResponse(
    @Json(name = "results")
    val locations: List<Location>
)