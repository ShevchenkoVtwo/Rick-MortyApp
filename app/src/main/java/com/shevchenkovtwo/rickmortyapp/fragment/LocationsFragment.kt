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
import com.shevchenkovtwo.rickmortyapp.viewmodel.LocationsViewModel
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.adapter.LocationsAdapter
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentEpisodesBinding
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentLocationsBinding

class LocationsFragment : Fragment() {
    private lateinit var locationsViewModel: LocationsViewModel
    private var fragmentLocationsBinding: FragmentLocationsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLocationsBinding.inflate(inflater, container, false)
        fragmentLocationsBinding = binding
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val recyclerView = fragmentLocationsBinding?.rvLocations
        locationsViewModel = ViewModelProvider(this).get(LocationsViewModel::class.java)
        locationsViewModel.locationsData.observe(viewLifecycleOwner, Observer {
            val episodesAdapter = LocationsAdapter(requireContext(), it)
            recyclerView?.layoutManager = LinearLayoutManager(requireContext())
            recyclerView?.adapter = episodesAdapter
        })
    }
}