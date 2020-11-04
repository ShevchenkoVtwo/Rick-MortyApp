package com.shevchenkovtwo.rickmortyapp.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shevchenkovtwo.rickmortyapp.NetworkService
import com.shevchenkovtwo.rickmortyapp.viewmodel.CharactersViewModel


class CharactersViewModelFactory(private val networkService: NetworkService) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharactersViewModel::class.java)) {
            return CharactersViewModel(networkService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}