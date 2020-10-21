package com.shevchenkovtwo.rickmortyapp.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shevchenkovtwo.rickmortyapp.viewmodel.LocationViewModel
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentEpisodeProflieBinding
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentLocationProfileBinding

class LocationFragment : Fragment() {

    private lateinit var locationModel: LocationViewModel
    private var fragmentEpisodeBinding: FragmentLocationProfileBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLocationProfileBinding.inflate(inflater, container, false)
        fragmentEpisodeBinding = binding
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        locationModel = ViewModelProvider(this).get(LocationViewModel::class.java)
        locationModel.getLocationLiveData().observe(viewLifecycleOwner, {
            fragmentEpisodeBinding?.layoutLocationCard?.tvLocationNameText?.text = it.name
            fragmentEpisodeBinding?.layoutLocationCard?.tvLocationDimensionText?.text = it.dimension
            fragmentEpisodeBinding?.layoutLocationCard?.tvLocationTypeText?.text = it.type
            fragmentEpisodeBinding?.layoutLocationCard?.tvCreatedTimeLocation?.text = it.created
        })
    }

}