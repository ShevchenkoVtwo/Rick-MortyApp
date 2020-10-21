package com.shevchenkovtwo.rickmortyapp.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shevchenkovtwo.rickmortyapp.viewmodel.EpisodeViewModel
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentEpisodeProflieBinding

class EpisodeFragment : Fragment() {

    private lateinit var episodeModel: EpisodeViewModel
    private var fragmentEpisodeBinding: FragmentEpisodeProflieBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEpisodeProflieBinding.inflate(inflater, container, false)
        fragmentEpisodeBinding = binding
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        episodeModel = ViewModelProvider(this).get(EpisodeViewModel::class.java)
        episodeModel.getEpisodeLiveData().observe(viewLifecycleOwner, {
            fragmentEpisodeBinding?.layoutEpisodeCard?.tvEpisodeNameText?.text = it.name
            fragmentEpisodeBinding?.layoutEpisodeCard?.tvCreatedTimeEpisode?.text = it.created
            fragmentEpisodeBinding?.layoutEpisodeCard?.tvEpisodeAirDateText?.text = it.airDate
            fragmentEpisodeBinding?.layoutEpisodeCard?.tvEpisodeCodeText?.text = it.code
        })
    }
}