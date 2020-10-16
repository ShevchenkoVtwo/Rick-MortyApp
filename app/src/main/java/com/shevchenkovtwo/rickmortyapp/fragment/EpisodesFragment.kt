package com.shevchenkovtwo.rickmortyapp.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shevchenkovtwo.rickmortyapp.viewmodel.EpisodesViewModel
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.adapter.CharactersAdapter
import com.shevchenkovtwo.rickmortyapp.adapter.EpisodesAdapter
import com.shevchenkovtwo.rickmortyapp.viewmodel.CharactersViewModel

class EpisodesFragment : Fragment() {

    private lateinit var episodesViewModel: EpisodesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.episodes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.rv_episodes)
        episodesViewModel = ViewModelProvider(this).get(EpisodesViewModel::class.java)
        episodesViewModel.episodesData.observe(viewLifecycleOwner, Observer {
            val episodesAdapter = EpisodesAdapter(requireContext(), it)
            recyclerView?.layoutManager = LinearLayoutManager(requireContext())
            recyclerView?.adapter = episodesAdapter
        })
    }

}