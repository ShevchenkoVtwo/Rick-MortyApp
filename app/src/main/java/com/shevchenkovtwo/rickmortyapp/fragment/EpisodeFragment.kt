package com.shevchenkovtwo.rickmortyapp.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
        episodeModel.getEpisodeLiveData().observe(viewLifecycleOwner,{
            view?.findViewById<TextView>(R.id.tv_episode_name_text)?.text = it.name
            view?.findViewById<TextView>(R.id.tv_episode_created_text)?.text = it.created
            view?.findViewById<TextView>(R.id.tv_episode_air_date_text)?.text = it?.airDate
            view?.findViewById<TextView>(R.id.tv_episode_code_text)?.text = it?.code
        })
    }
}