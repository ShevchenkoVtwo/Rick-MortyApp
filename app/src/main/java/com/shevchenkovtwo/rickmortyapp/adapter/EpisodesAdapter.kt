package com.shevchenkovtwo.rickmortyapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.databinding.ListViewEpisodeItemBinding
import com.shevchenkovtwo.rickmortyapp.model.Episode

class EpisodesAdapter(private var context: Context, private var episodesList: List<Episode>) :
    RecyclerView.Adapter<EpisodesAdapter.ViewHolder>() {
    class ViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        val binding = ListViewEpisodeItemBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.list_view_episode_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.tvEpisodeName.text = episodesList[position].name
            item.setOnClickListener {
                AppConstants.episodeSelected = episodesList[position]
                item.findNavController()
                    .navigate(R.id.action_episodesFragment_to_episodeFragment)
            }
        }
    }

    override fun getItemCount(): Int {
        return episodesList.size
    }
}

