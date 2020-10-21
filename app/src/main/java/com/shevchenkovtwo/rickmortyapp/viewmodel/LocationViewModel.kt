package com.shevchenkovtwo.rickmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.model.Location

class LocationViewModel : ViewModel() {
    var locationData: MutableLiveData<Location>? = null

    init {
        locationData = MutableLiveData()
    }

    fun getLocationLiveData(): MutableLiveData<Location> {
        if (locationData == null)
            locationData = MutableLiveData()
        locationData?.value = AppConstants.locationSelected
        return locationData!!
    }
}