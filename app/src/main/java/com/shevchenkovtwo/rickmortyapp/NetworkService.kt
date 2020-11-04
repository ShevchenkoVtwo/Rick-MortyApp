package com.shevchenkovtwo.rickmortyapp

import com.shevchenkovtwo.rickmortyapp.responses.CharactersResponse
import com.shevchenkovtwo.rickmortyapp.responses.EpisodesResponse
import com.shevchenkovtwo.rickmortyapp.responses.LocationsResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface NetworkService {

    @GET("character/")
    suspend fun getAllCharacters(@Query("page") page: Int): Response<CharactersResponse>

    @GET("location/")
    suspend fun getAllLocations(@Query("page") page: Int): Response<LocationsResponse>

    @GET("episode/")
    suspend fun getAllEpisodes(@Query("page") page: Int): Response<EpisodesResponse>

    companion object  {
        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        fun getService() = Retrofit.Builder()
            .baseUrl(AppConstants.baseUri)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(NetworkService::class.java)
    }
}
