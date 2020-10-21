package com.shevchenkovtwo.rickmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.loadCharacters
import com.shevchenkovtwo.rickmortyapp.loadPages
import com.shevchenkovtwo.rickmortyapp.model.Character
import com.shevchenkovtwo.rickmortyapp.model.Info
import kotlinx.coroutines.launch


class CharactersViewModel : ViewModel() {
    var charactersData: MutableLiveData<List<Character>> = MutableLiveData()
    private var info: Info? = null

    init {
        viewModelScope.launch {
            info = loadPages("character")
            charactersData.value = loadCharacters(AppConstants.pageCounter)
        }
    }
}



