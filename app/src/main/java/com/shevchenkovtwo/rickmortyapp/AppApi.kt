package com.shevchenkovtwo.rickmortyapp

import com.shevchenkovtwo.rickmortyapp.responses.CharactersResponse
import com.shevchenkovtwo.rickmortyapp.responses.EpisodesResponse
import com.shevchenkovtwo.rickmortyapp.responses.LocationsResponse
import retrofit2.Response
import retrofit2.http.GET

interface AppApi {
    @GET("character/")
    suspend fun getAllCharacters(): Response<CharactersResponse>

    @GET("location/")
    suspend fun getAllLocations(): Response<LocationsResponse>

    @GET("episode/")
    suspend fun getAllEpisodes(): Response<EpisodesResponse>
}