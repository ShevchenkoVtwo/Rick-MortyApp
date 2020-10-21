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
import com.shevchenkovtwo.rickmortyapp.model.Location

class LocationsAdapter(private var context: Context, private var locationsList: List<Location>) :
    RecyclerView.Adapter<LocationsAdapter.ViewHolder>() {
    class ViewHolder(val item: View) : RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.list_view_location_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.findViewById<TextView>(R.id.tv_location_name).text =
            locationsList[position].name
        holder.item.setOnClickListener {
            AppConstants.locationSelected = locationsList[position]
            holder.item.findNavController()
                .navigate(R.id.action_locationsFragment_to_locationFragment)
        }
    }

    override fun getItemCount(): Int {
        return locationsList.size
    }
}
