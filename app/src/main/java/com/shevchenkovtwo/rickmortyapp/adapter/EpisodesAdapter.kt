package com.shevchenkovtwo.rickmortyapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.model.Episode

class EpisodesAdapter(private var context: Context, private var episodesList: List<Episode>) :
    RecyclerView.Adapter<EpisodesAdapter.ViewHolder>() {
    class ViewHolder(val item: View) : RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.list_view_episode_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.findViewById<TextView>(R.id.tv_episode_name).text =
            episodesList[position].name
        holder.item.setOnClickListener {
            AppConstants.episodeSelected = episodesList[position]
            holder.item.findNavController()
                .navigate(R.id.action_episodesFragment_to_episodeFragment)
        }
    }

    override fun getItemCount(): Int {
        return episodesList.size
    }
}

