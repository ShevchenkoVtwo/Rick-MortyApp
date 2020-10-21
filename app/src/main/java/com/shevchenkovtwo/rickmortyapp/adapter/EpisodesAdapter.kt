package com.shevchenkovtwo.rickmortyapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.model.Episode

class EpisodesAdapter(private var context: Context, private var episodesList: List<Episode>) :
    RecyclerView.Adapter<EpisodesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var episodeName: TextView? = null
        var episodeAirDate: TextView? = null
        var episodeCode: TextView? = null

        init {
            episodeName = itemView.findViewById(R.id.tv_episode_name) as TextView
            episodeAirDate = itemView.findViewById(R.id.tv_episode_air_date) as TextView
            episodeCode = itemView.findViewById(R.id.tv_episode_code) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.list_view_episode_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.episodeName?.text = episodesList[position].name
        holder.episodeAirDate?.text = episodesList[position].airDate
        holder.episodeCode?.text = episodesList[position].code
    }

    override fun getItemCount(): Int {
        return episodesList.size
    }
}

