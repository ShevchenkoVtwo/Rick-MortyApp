package com.shevchenkovtwo.rickmortyapp.ui.fragment

import android.graphics.Color.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.shevchenkovtwo.rickmortyapp.common.AppConstants
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentCharacterProfileBinding
import com.shevchenkovtwo.rickmortyapp.viewmodel.CharacterViewModel


class CharacterFragment : Fragment() {

    private lateinit var characterViewModel: CharacterViewModel
    private var fragmentCharacterBinding: FragmentCharacterProfileBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentCharacterProfileBinding.inflate(inflater, container, false)
        fragmentCharacterBinding = binding
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        characterViewModel.getCharacterLiveData().observe(viewLifecycleOwner, { character ->
            fragmentCharacterBinding?.let {
                it.apply {
                    characterDataCard.characterName.text = character.name
                    characterDataCard.characterGender.text = character.gender
                    characterDataCard.characterSpecies.text = character.species
                    characterDataCard.characterCreated.text = character.created
                    characterDataCard.characterStatus.text = character.status
                    setStatusTextColor(characterDataCard.characterStatus.text as String)
                    Glide.with(requireContext()).load(character.image).into(characterImage)
                }
            }
        })
    }

    private fun setStatusTextColor(status: String) {
        fragmentCharacterBinding?.let {
            it.apply {
                when (status) {
                    AppConstants.statusAlive -> characterDataCard.characterStatus.setTextColor(GREEN)
                    AppConstants.statusDead -> characterDataCard.characterStatus.setTextColor(RED)
                    AppConstants.statusUnknown -> characterDataCard.characterStatus.setTextColor(YELLOW)
                }
            }
        }
    }

    override fun onDestroyView() {
        fragmentCharacterBinding = null
        super.onDestroyView()
    }
}