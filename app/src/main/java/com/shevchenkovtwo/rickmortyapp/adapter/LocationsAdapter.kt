package com.shevchenkovtwo.rickmortyapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.model.Location

class LocationsAdapter(private var context: Context, private var locationsList: List<Location>) :
    RecyclerView.Adapter<LocationsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var locationName: TextView? = null
        var locationType: TextView? = null
        var locationDimension: TextView? = null

        init {
            locationName = itemView.findViewById(R.id.tv_location_name) as TextView
            locationType = itemView.findViewById(R.id.tv_location_type) as TextView
            locationDimension = itemView.findViewById(R.id.tv_location_dimension) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.list_view_location_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.locationName?.text = locationsList[position].name
        holder.locationType?.text = locationsList[position].type
        holder.locationDimension?.text = locationsList[position].dimension
    }

    override fun getItemCount(): Int {
        return locationsList.size
    }
}
