package com.shevchenkovtwo.rickmortyapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.shevchenkovtwo.rickmortyapp.AppApi
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.AppConstants.TAG
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CharactersViewModel : ViewModel() {
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
            val result = api.getAllCharacters()
            result.body()?.characters?.forEach {
                Log.e(TAG, it.name)
            }
        }
    }
}