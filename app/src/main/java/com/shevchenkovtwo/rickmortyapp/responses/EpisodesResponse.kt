package com.shevchenkovtwo.rickmortyapp.responses

import com.shevchenkovtwo.rickmortyapp.model.Episode
import com.squareup.moshi.Json


data class EpisodesResponse(
    @Json(name="results")
    val episodes: List<Episode>
)
