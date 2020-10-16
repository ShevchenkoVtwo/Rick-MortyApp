package com.shevchenkovtwo.rickmortyapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.GsonBuilder
import com.shevchenkovtwo.rickmortyapp.AppApi
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.AppConstants.TAG
import com.shevchenkovtwo.rickmortyapp.model.Character
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CharactersViewModel : ViewModel() {

    val charactersData: MutableLiveData<List<Character>> = MutableLiveData()

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
            result.body()?.characters?.let {
                charactersData.postValue(it)
            }

        }
    }
}