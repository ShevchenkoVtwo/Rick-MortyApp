package com.shevchenkovtwo.rickmortyapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.shevchenkovtwo.rickmortyapp.NetworkService
import com.shevchenkovtwo.rickmortyapp.datasource.CharactersDataSource


class CharactersViewModel(private val networkService: NetworkService) : ViewModel() {
    val charactersData = Pager(PagingConfig(pageSize = 20)) {
        CharactersDataSource(networkService)
    }.liveData.cachedIn(viewModelScope)
}