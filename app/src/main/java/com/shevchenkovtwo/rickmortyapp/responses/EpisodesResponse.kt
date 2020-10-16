package com.shevchenkovtwo.rickmortyapp.responses

import com.google.gson.annotations.SerializedName
import com.shevchenkovtwo.rickmortyapp.model.Episode

data class EpisodesResponse(
    @SerializedName("results")
    val episodes: List<Episode>
)
