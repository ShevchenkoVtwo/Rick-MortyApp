package com.shevchenkovtwo.rickmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shevchenkovtwo.rickmortyapp.common.AppConstants
import com.shevchenkovtwo.rickmortyapp.data.database.model.Character


class CharacterViewModel : ViewModel() {
    private var characterData: MutableLiveData<Character>? = null

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