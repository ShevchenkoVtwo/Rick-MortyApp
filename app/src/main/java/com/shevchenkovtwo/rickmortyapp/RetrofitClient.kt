package com.shevchenkovtwo.rickmortyapp

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.shevchenkovtwo.rickmortyapp.model.Character
import com.shevchenkovtwo.rickmortyapp.model.Info
import com.shevchenkovtwo.rickmortyapp.Retrofit.api
import com.shevchenkovtwo.rickmortyapp.model.Episode
import com.shevchenkovtwo.rickmortyapp.model.Location
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    val gson: Gson = GsonBuilder()
        .setLenient()
        .create()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(AppConstants.baseUri)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    val api: AppRetrofitApiResponces = retrofit.create(AppRetrofitApiResponces::class.java)
}

suspend fun loadCharacters(pages: Int): List<Character> {
    val result = api.getAllCharacters(pages)
    return result.body()?.characters!!
}

suspend fun loadEpisodes(pages: Int): List<Episode> {
    val result = api.getAllEpisodes(pages)
    return result.body()?.episodes!!
}

suspend fun loadLocations(pages: Int): List<Location> {
    val result = api.getAllLocations(pages)
    return result.body()?.locations!!
}

suspend fun loadPages(pageName: String): Info {
    val result = api.getInfo(pageName)
    return result.body()?.info!!
}