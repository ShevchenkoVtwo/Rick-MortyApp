package com.shevchenkovtwo.rickmortyapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.model.Character

class CharactersAdapter(private var context: Context, private var charactersList: List<Character>) :
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {
    class ViewHolder(val item: View) : RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.list_view_character_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.findViewById<TextView>(R.id.tv_character_name).text =
            charactersList[position].name
        holder.item.findViewById<TextView>(R.id.tv_character_status).text =
            charactersList[position].status
        Glide.with(context)
            .load(charactersList[position].image)
            .into(holder.item.findViewById(R.id.imv_character))
        holder.item.setOnClickListener {
            AppConstants.characterSelected = charactersList[position]
            holder.item.findNavController()
                .navigate(R.id.action_charactersFragment_to_characterFragment)
        }
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
}