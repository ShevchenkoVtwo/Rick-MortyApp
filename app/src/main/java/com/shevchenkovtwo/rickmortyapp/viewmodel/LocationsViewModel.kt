package com.shevchenkovtwo.rickmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.GsonBuilder
import com.shevchenkovtwo.rickmortyapp.AppRetrofitApiResponces
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.model.Location
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocationsViewModel : ViewModel() {
    val locationsData: MutableLiveData<List<Location>> = MutableLiveData()

    init {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.baseUri)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val api = retrofit.create(AppRetrofitApiResponces::class.java)

        viewModelScope.launch {
            val result = api.getAllLocations(1)
            result.body()?.locations?.let {
                locationsData.postValue(it)
            }

        }
    }
}