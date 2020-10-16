package com.shevchenkovtwo.rickmortyapp.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shevchenkovtwo.rickmortyapp.viewmodel.LocationViewModel
import com.shevchenkovtwo.rickmortyapp.R

class LocationFragment : Fragment() {

    private lateinit var viewModel: LocationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.location_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LocationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}