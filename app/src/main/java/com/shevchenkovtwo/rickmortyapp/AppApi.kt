package com.shevchenkovtwo.rickmortyapp

import com.shevchenkovtwo.rickmortyapp.model.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET

interface AppApi {
    @GET("character/")
    suspend fun getAllCharacters():Response<CharactersResponse>
}