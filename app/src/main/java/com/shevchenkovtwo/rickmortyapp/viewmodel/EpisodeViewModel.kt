package com.shevchenkovtwo.rickmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.model.Episode

class EpisodeViewModel : ViewModel() {
    var episodeData: MutableLiveData<Episode>? = null

    init {
        episodeData = MutableLiveData()
    }

    fun getEpisodeLiveData(): MutableLiveData<Episode> {
        if (episodeData == null)
            episodeData = MutableLiveData()
        episodeData?.value = AppConstants.episodeSelected
        return episodeData!!
    }
}