package com.shevchenkovtwo.rickmortyapp.fragment

import android.graphics.Color
import android.graphics.Color.GREEN
import android.graphics.Color.RED
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentCharacterProfileBinding
import com.shevchenkovtwo.rickmortyapp.viewmodel.CharacterViewModel

class CharacterFragment : Fragment() {

    private lateinit var characterViewModel: CharacterViewModel
    private var fragmentCharacterBinding: FragmentCharacterProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCharacterProfileBinding.inflate(inflater, container, false)
        fragmentCharacterBinding = binding
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        characterViewModel.getCharacterLiveData().observe(viewLifecycleOwner, {
            fragmentCharacterBinding?.layoutCharacterCard?.tvCharacterNameText?.text = it.name
            fragmentCharacterBinding?.layoutCharacterCard?.tvCharacterSpeciesText?.text = it.species
            fragmentCharacterBinding?.layoutCharacterCard?.tvCharacterGenderText?.text = it.gender
            fragmentCharacterBinding?.layoutCharacterCard?.tvCharacterCreatedText?.text = it.created
            fragmentCharacterBinding?.layoutCharacterCard?.tvCharacterStatusText?.text = it.status
            when (it.status) {
                AppConstants.statusAlive -> fragmentCharacterBinding?.layoutCharacterCard?.tvCharacterStatusText
                    ?.setTextColor(GREEN)
                AppConstants.statusDead -> fragmentCharacterBinding?.layoutCharacterCard?.tvCharacterStatusText
                    ?.setTextColor(RED)
                AppConstants.statusUnknown -> fragmentCharacterBinding?.layoutCharacterCard?.tvCharacterStatusText
                    ?.setTextColor(Color.YELLOW)
            }
            fragmentCharacterBinding?.imvCharacterImage?.let { image ->
                Glide.with(requireContext()).load(it?.image)
                    .into(image)
            }
        })
    }

    override fun onDestroyView() {
        fragmentCharacterBinding = null
        super.onDestroyView()
    }
}