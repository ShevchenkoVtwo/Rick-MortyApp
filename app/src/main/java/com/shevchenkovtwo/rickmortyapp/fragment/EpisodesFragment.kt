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
import com.shevchenkovtwo.rickmortyapp.adapter.EpisodesAdapter
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentCharactersBinding
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentEpisodesBinding

class EpisodesFragment : Fragment() {

    private lateinit var episodesViewModel: EpisodesViewModel
    private var fragmentEpisodesBinding: FragmentEpisodesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        fragmentEpisodesBinding = binding
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val recyclerView = fragmentEpisodesBinding?.rvEpisodes
        episodesViewModel = ViewModelProvider(this).get(EpisodesViewModel::class.java)
        episodesViewModel.episodesData.observe(viewLifecycleOwner, Observer {
            val episodesAdapter = EpisodesAdapter(requireContext(), it)
            recyclerView?.layoutManager = LinearLayoutManager(requireContext())
            recyclerView?.adapter = episodesAdapter
        })
    }

}