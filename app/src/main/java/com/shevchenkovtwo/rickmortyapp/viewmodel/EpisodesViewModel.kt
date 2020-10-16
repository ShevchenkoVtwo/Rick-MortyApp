package com.shevchenkovtwo.rickmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.GsonBuilder
import com.shevchenkovtwo.rickmortyapp.AppApi
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.model.Episode
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EpisodesViewModel : ViewModel() {
    val episodesData: MutableLiveData<List<Episode>> = MutableLiveData()

    init {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.baseUri)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val api = retrofit.create(AppApi::class.java)

        viewModelScope.launch {
            val result = api.getAllEpisodes()
            result.body()?.episodes?.let {
                episodesData.postValue(it)
            }

        }
    }
}