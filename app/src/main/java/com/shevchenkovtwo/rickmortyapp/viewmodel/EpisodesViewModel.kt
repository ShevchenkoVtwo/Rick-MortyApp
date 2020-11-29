package com.shevchenkovtwo.rickmortyapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.shevchenkovtwo.rickmortyapp.data.network.NetworkService
import com.shevchenkovtwo.rickmortyapp.data.datasource.EpisodesDataSource


class EpisodesViewModel(private val networkService: NetworkService) : ViewModel() {
    val episodesData = Pager(PagingConfig(pageSize = 20)) {
        EpisodesDataSource(networkService)
    }.liveData.cachedIn(viewModelScope)
}