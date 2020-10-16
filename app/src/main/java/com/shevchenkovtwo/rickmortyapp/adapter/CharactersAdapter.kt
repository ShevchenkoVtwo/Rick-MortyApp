package com.shevchenkovtwo.rickmortyapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.model.Character

class CharactersAdapter(
    internal var context: Context,
    private var charactersList: List<Character>
) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var characterName: TextView? = null
        var characterStatus: TextView? = null
        var characterSpecies: TextView? = null
        var characterCreated: TextView? = null
        var characterImage: ImageView? = null

        init {
            characterName = itemView.findViewById(R.id.tv_name) as TextView
            characterStatus = itemView.findViewById(R.id.tv_status) as TextView
            characterSpecies = itemView.findViewById(R.id.tv_species) as TextView
            characterCreated = itemView.findViewById(R.id.tv_created) as TextView
            characterImage = itemView.findViewById(R.id.imv_character) as ImageView
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.character_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
       return charactersList.size
    }
}