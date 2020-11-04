package com.shevchenkovtwo.rickmortyapp.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shevchenkovtwo.rickmortyapp.NetworkService
import com.shevchenkovtwo.rickmortyapp.viewmodel.EpisodesViewModel
import com.shevchenkovtwo.rickmortyapp.adapter.EpisodesAdapter
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentEpisodesBinding
import com.shevchenkovtwo.rickmortyapp.factories.EpisodesViewModelFactory
import kotlinx.coroutines.launch

class EpisodesFragment : Fragment() {

    private var fragmentEpisodesBinding: FragmentEpisodesBinding? = null
    private lateinit var episodesViewModel: EpisodesViewModel
    private lateinit var locationsAdapter: EpisodesAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        fragmentEpisodesBinding = binding
        recyclerView = binding.rvEpisodes
        setupViewModel()
        setupList(binding.root)
        setupView()
        return binding.root
    }

    private fun setupView() {
        episodesViewModel.episodesData.observe(viewLifecycleOwner, {
            lifecycleScope.launch {
                locationsAdapter.submitData(it)
            }
        })
    }

    private fun setupList(view: View) {
        locationsAdapter = EpisodesAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = locationsAdapter
        }
    }

    private fun setupViewModel() {
        episodesViewModel =
            ViewModelProvider(
                this,
                EpisodesViewModelFactory(networkService = NetworkService.getService())
            )[EpisodesViewModel::class.java]
    }

    override fun onDestroyView() {
        fragmentEpisodesBinding = null
        super.onDestroyView()
    }
}