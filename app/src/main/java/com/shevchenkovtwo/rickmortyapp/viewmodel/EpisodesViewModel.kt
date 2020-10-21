package com.shevchenkovtwo.rickmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.loadEpisodes
import com.shevchenkovtwo.rickmortyapp.model.Episode
import kotlinx.coroutines.launch

class EpisodesViewModel : ViewModel() {
    val episodesData: MutableLiveData<List<Episode>> = MutableLiveData()

    init {
        viewModelScope.launch {
            episodesData.value = loadEpisodes(AppConstants.pageCounter)
        }
    }
}