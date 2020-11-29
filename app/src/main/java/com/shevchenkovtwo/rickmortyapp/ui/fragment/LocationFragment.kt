package com.shevchenkovtwo.rickmortyapp.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shevchenkovtwo.rickmortyapp.viewmodel.LocationViewModel
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentLocationProfileBinding


class LocationFragment : Fragment() {

    private lateinit var locationModel: LocationViewModel
    private var fragmentLocationBinding: FragmentLocationProfileBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentLocationProfileBinding.inflate(inflater, container, false)
        fragmentLocationBinding = binding
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        locationModel = ViewModelProvider(this).get(LocationViewModel::class.java)
        locationModel.getLocationLiveData().observe(viewLifecycleOwner, { location ->
            fragmentLocationBinding?.let {
                it.apply {
                    locationDataCard.locationName.text = location.name
                    locationDataCard.locationDimension.text = location.dimension
                    locationDataCard.locationType.text = location.type
                    locationDataCard.locationCreated.text = location.created
                }
            }
        })
    }

    override fun onDestroyView() {
        fragmentLocationBinding = null
        super.onDestroyView()
    }
}