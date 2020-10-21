package com.shevchenkovtwo.rickmortyapp.model

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("count") val objectsCount: Int,
    @SerializedName("pages") val page: Int
)