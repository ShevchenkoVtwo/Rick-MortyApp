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

class LocationFragment : Fragment() {

    private lateinit var locationModel: LocationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_location_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        locationModel = ViewModelProvider(this).get(LocationViewModel::class.java)
        locationModel.getLocationLiveData().observe(viewLifecycleOwner,{
            view?.findViewById<TextView>(R.id.tv_location_name_text)?.text = it.name
            view?.findViewById<TextView>(R.id.tv_location_dimension_text)?.text = it.dimension
            view?.findViewById<TextView>(R.id.tv_location_type_text)?.text = it?.type
            view?.findViewById<TextView>(R.id.tv_location_created_text)?.text = it?.created
        })
    }

}