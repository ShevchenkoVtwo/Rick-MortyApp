package com.shevchenkovtwo.rickmortyapp.fragment

import android.graphics.Color
import android.graphics.Color.GREEN
import android.graphics.Color.RED
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.viewmodel.CharacterViewModel

class CharacterFragment : Fragment() {

    private lateinit var characterViewModel: CharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        characterViewModel.getCharacterLiveData().observe(viewLifecycleOwner, {
            view?.findViewById<TextView>(R.id.tv_character_name_text)?.text = it.name
            view?.findViewById<TextView>(R.id.tv_character_status_text)?.text = it.status
            when (it.status) {
                "Alive" -> view?.findViewById<TextView>(R.id.tv_character_status_text)
                    ?.setTextColor(GREEN)
                "Dead" -> view?.findViewById<TextView>(R.id.tv_character_status_text)
                    ?.setTextColor(RED)
                "unknown" -> view?.findViewById<TextView>(R.id.tv_character_status_text)
                    ?.setTextColor(Color.YELLOW)
            }
            view?.findViewById<TextView>(R.id.tv_character_species_text)?.text = it?.species
            view?.findViewById<TextView>(R.id.tv_character_gender_text)?.text = it?.gender
            view?.findViewById<TextView>(R.id.tv_character_created_text)?.text = it?.created
            view?.findViewById<ImageView>(R.id.imv_character_image)?.let { image ->
                Glide.with(requireContext()).load(it?.image)
                    .into(image)
            }
        })
    }
}