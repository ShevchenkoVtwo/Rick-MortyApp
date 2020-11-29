package com.shevchenkovtwo.rickmortyapp.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shevchenkovtwo.rickmortyapp.data.network.NetworkService
import com.shevchenkovtwo.rickmortyapp.viewmodel.LocationsViewModel
import com.shevchenkovtwo.rickmortyapp.ui.adapter.LocationsAdapter
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentLocationsBinding
import com.shevchenkovtwo.rickmortyapp.factories.LocationsViewModelFactory
import kotlinx.coroutines.launch


class LocationsFragment : Fragment() {

    private var fragmentLocationsBinding: FragmentLocationsBinding? = null
    private lateinit var locationsViewModel: LocationsViewModel
    private lateinit var locationsAdapter: LocationsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentLocationsBinding.inflate(inflater, container, false)
        fragmentLocationsBinding = binding
        recyclerView = binding.rvLocations
        setupViewModel()
        setupList(binding.root)
        setupView()
        return binding.root
    }

    private fun setupView() {
        locationsViewModel.locationsData.observe(viewLifecycleOwner, {
            lifecycleScope.launch {
                locationsAdapter.submitData(it)
            }
        })
    }

    private fun setupList(view: View) {
        locationsAdapter = LocationsAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = locationsAdapter
        }
    }

    private fun setupViewModel() {
        locationsViewModel =
            ViewModelProvider(
                this,
                LocationsViewModelFactory(networkService = NetworkService.getService())
            )[LocationsViewModel::class.java]
    }

    override fun onDestroyView() {
        fragmentLocationsBinding = null
        super.onDestroyView()
    }
}