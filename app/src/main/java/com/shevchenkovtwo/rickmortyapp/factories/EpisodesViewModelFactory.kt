package com.shevchenkovtwo.rickmortyapp.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shevchenkovtwo.rickmortyapp.NetworkService
import com.shevchenkovtwo.rickmortyapp.viewmodel.EpisodesViewModel


class EpisodesViewModelFactory(private val networkService: NetworkService) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EpisodesViewModel::class.java)) {
            return EpisodesViewModel(networkService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}