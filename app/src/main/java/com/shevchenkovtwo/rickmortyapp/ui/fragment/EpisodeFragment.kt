package com.shevchenkovtwo.rickmortyapp.ui.fragment

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentEpisodeProflieBinding.inflate(inflater, container, false)
        fragmentEpisodeBinding = binding
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        episodeModel = ViewModelProvider(this).get(EpisodeViewModel::class.java)
        episodeModel.getEpisodeLiveData().observe(viewLifecycleOwner, { episode ->
            fragmentEpisodeBinding?.let {
                it.apply {
                    episodeDataCard.episodeName.text = episode.name
                    episodeDataCard.episodeCode.text = episode.code
                    episodeDataCard.episodeAirDate.text = episode.airDate
                    episodeDataCard.episodeCreated.text = episode.created
                }
            }
        })
    }

    override fun onDestroyView() {
        fragmentEpisodeBinding = null
        super.onDestroyView()
    }
}