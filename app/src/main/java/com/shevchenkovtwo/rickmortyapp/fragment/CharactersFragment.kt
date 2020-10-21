package com.shevchenkovtwo.rickmortyapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.adapter.CharactersAdapter
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentCharacterProfileBinding
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentCharactersBinding
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentEpisodeProflieBinding
import com.shevchenkovtwo.rickmortyapp.viewmodel.CharactersViewModel

class CharactersFragment : Fragment() {

    private lateinit var charactersViewModel: CharactersViewModel
    private var fragmentCharactersBinding: FragmentCharactersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCharactersBinding.inflate(inflater, container, false)
        fragmentCharactersBinding = binding
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val recyclerView = fragmentCharactersBinding?.rvCharacters
        charactersViewModel = ViewModelProvider(this).get(CharactersViewModel::class.java)
        charactersViewModel.charactersData.observe(viewLifecycleOwner, Observer {
            val charactersAdapter = CharactersAdapter(requireContext(), it)
            recyclerView?.layoutManager = LinearLayoutManager(requireContext())
            recyclerView?.adapter = charactersAdapter
        })
    }
}

