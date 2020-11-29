package com.shevchenkovtwo.rickmortyapp.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shevchenkovtwo.rickmortyapp.data.network.NetworkService
import com.shevchenkovtwo.rickmortyapp.viewmodel.LocationsViewModel


class LocationsViewModelFactory(private val networkService: NetworkService) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LocationsViewModel::class.java)) {
            return LocationsViewModel(networkService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}