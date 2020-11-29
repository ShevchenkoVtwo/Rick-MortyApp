package com.shevchenkovtwo.rickmortyapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shevchenkovtwo.rickmortyapp.factories.CharactersViewModelFactory
import com.shevchenkovtwo.rickmortyapp.data.network.NetworkService
import com.shevchenkovtwo.rickmortyapp.ui.adapter.CharactersAdapter
import com.shevchenkovtwo.rickmortyapp.databinding.FragmentCharactersBinding
import com.shevchenkovtwo.rickmortyapp.viewmodel.CharactersViewModel
import kotlinx.coroutines.launch


class CharactersFragment : Fragment() {

    private var fragmentCharactersBinding: FragmentCharactersBinding? = null
    private lateinit var charactersViewModel: CharactersViewModel
    private lateinit var charactersAdapter: CharactersAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentCharactersBinding.inflate(inflater, container, false)
        fragmentCharactersBinding = binding
        recyclerView = binding.rvCharacters
        setupViewModel()
        setupList(binding.root)
        setupView()
        return binding.root
    }

    private fun setupView() {
        charactersViewModel.charactersData.observe(viewLifecycleOwner, {
            lifecycleScope.launch {
                charactersAdapter.submitData(it)
            }
        })
    }

    private fun setupList(view: View) {
        charactersAdapter = CharactersAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = charactersAdapter
        }
    }

    private fun setupViewModel() {
        charactersViewModel =
            ViewModelProvider(
                this,
                CharactersViewModelFactory(networkService = NetworkService.getService())
            )[CharactersViewModel::class.java]
    }

    override fun onDestroyView() {
        fragmentCharactersBinding = null
        super.onDestroyView()
    }
}

