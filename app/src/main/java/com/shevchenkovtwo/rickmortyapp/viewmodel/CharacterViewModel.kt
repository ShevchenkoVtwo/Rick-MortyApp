package com.shevchenkovtwo.rickmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.model.Character

class CharacterViewModel : ViewModel() {
    var characterData: MutableLiveData<Character>? = null

    init {
        characterData = MutableLiveData()
    }

    fun getCharacterLiveData(): MutableLiveData<Character> {
        if (characterData == null)
            characterData = MutableLiveData()
        characterData?.value = AppConstants.characterSelected
        return characterData!!
    }
}