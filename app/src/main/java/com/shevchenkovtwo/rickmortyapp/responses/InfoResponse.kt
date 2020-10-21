package com.shevchenkovtwo.rickmortyapp.responses

import com.google.gson.annotations.SerializedName
import com.shevchenkovtwo.rickmortyapp.model.Info

data class InfoResponse(@SerializedName("info") val info:Info)