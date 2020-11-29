package com.shevchenkovtwo.rickmortyapp.data.network.responses

import com.shevchenkovtwo.rickmortyapp.data.database.model.Episode
import com.squareup.moshi.Json


data class EpisodesResponse(
    @Json(name="results")
    val episodes: List<Episode>
)
