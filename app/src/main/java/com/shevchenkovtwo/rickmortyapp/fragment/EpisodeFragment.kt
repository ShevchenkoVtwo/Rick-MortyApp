package com.shevchenkovtwo.rickmortyapp.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shevchenkovtwo.rickmortyapp.viewmodel.EpisodeViewModel
import com.shevchenkovtwo.rickmortyapp.R

class EpisodeFragment : Fragment() {

    private lateinit var episodeModel: EpisodeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_episode_proflie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        episodeModel = ViewModelProvider(this).get(EpisodeViewModel::class.java)
    }

}