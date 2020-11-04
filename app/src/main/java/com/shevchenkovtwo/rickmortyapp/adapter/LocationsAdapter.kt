package com.shevchenkovtwo.rickmortyapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.databinding.ListViewLocationItemBinding
import com.shevchenkovtwo.rickmortyapp.model.Location

class LocationsAdapter: PagingDataAdapter<Location, LocationsAdapter.ViewHolder>(LocationDifferentiate) {
    class ViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        val binding = ListViewLocationItemBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_view_location_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.tvLocationName.text = getItem(position)?.name
            item.setOnClickListener {
                AppConstants.locationSelected = getItem(position)
                item.findNavController()
                    .navigate(R.id.action_locationsFragment_to_locationFragment)
            }
        }
    }

    object LocationDifferentiate : DiffUtil.ItemCallback<Location>() {
        override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem == newItem
        }
    }
}
