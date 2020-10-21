package com.shevchenkovtwo.rickmortyapp

import com.shevchenkovtwo.rickmortyapp.responses.CharactersResponse
import com.shevchenkovtwo.rickmortyapp.responses.EpisodesResponse
import com.shevchenkovtwo.rickmortyapp.responses.LocationsResponse
import com.shevchenkovtwo.rickmortyapp.responses.InfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppRetrofitApiResponces {
    @GET("{pageName}/")
    suspend fun getInfo(@Path("pageName") pageName:String):Response<InfoResponse>

    @GET("character/")
    suspend fun getAllCharacters(@Query("page")page:Int): Response<CharactersResponse>

    @GET("location/")
    suspend fun getAllLocations(@Query("page")page:Int): Response<LocationsResponse>

    @GET("episode/")
    suspend fun getAllEpisodes(@Query("page")page:Int): Response<EpisodesResponse>

}