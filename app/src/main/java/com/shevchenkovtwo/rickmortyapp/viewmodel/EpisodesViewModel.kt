package com.shevchenkovtwo.rickmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.loadEpisodes
import com.shevchenkovtwo.rickmortyapp.loadPages
import com.shevchenkovtwo.rickmortyapp.model.Episode
import com.shevchenkovtwo.rickmortyapp.model.Info
import kotlinx.coroutines.launch

class EpisodesViewModel : ViewModel() {
    val episodesData: MutableLiveData<List<Episode>> = MutableLiveData()
    private var info: Info? = null

    init {
        viewModelScope.launch {
            info = loadPages("episode")
            episodesData.value = loadEpisodes(AppConstants.pageCounter)
        }
    }
}