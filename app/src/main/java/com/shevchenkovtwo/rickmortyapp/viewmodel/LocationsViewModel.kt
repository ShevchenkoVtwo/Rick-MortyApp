package com.shevchenkovtwo.rickmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shevchenkovtwo.rickmortyapp.*
import com.shevchenkovtwo.rickmortyapp.model.Info
import com.shevchenkovtwo.rickmortyapp.model.Location
import kotlinx.coroutines.launch

class LocationsViewModel : ViewModel() {
    val locationsData: MutableLiveData<List<Location>> = MutableLiveData()
    private var info: Info? = null

    init {
        viewModelScope.launch {
            info = loadPages("location")
            locationsData.value = loadLocations(AppConstants.pageCounter)
        }
    }
}
