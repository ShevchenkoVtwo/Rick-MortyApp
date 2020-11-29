package com.shevchenkovtwo.rickmortyapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shevchenkovtwo.rickmortyapp.common.AppConstants
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.databinding.ListViewEpisodeItemBinding
import com.shevchenkovtwo.rickmortyapp.data.database.model.Episode


class EpisodesAdapter : PagingDataAdapter<Episode, EpisodesAdapter.ViewHolder>(EpisodeDifferentiate) {
    class ViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        val binding = ListViewEpisodeItemBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_view_episode_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.listEpisodeName.text = getItem(position)?.name
            item.setOnClickListener {
                AppConstants.episodeSelected = getItem(position)
                item.findNavController()
                    .navigate(R.id.action_episodesFragment_to_episodeFragment)
            }
        }
    }

    object EpisodeDifferentiate : DiffUtil.ItemCallback<Episode>() {
        override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
            return oldItem == newItem
        }
    }
}

