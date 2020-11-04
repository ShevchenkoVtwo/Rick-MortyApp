package com.shevchenkovtwo.rickmortyapp.adapter

import android.graphics.Color.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.model.Character
import com.shevchenkovtwo.rickmortyapp.databinding.ListViewCharacterItemBinding

class CharactersAdapter :
    PagingDataAdapter<Character, CharactersAdapter.ViewHolder>(CharacterDifferentiate) {

    class ViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        val binding = ListViewCharacterItemBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_view_character_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.tvCharacterName.text = getItem(position)?.name
            binding.tvCharacterStatus.text = getItem(position)?.status
            when (getItem(position)?.status) {
                AppConstants.statusAlive -> binding.tvCharacterStatus.setTextColor(GREEN)
                AppConstants.statusDead -> binding.tvCharacterStatus.setTextColor(RED)
                AppConstants.statusUnknown -> binding.tvCharacterStatus.setTextColor(YELLOW)
            }
            Glide.with(binding.root)
                .load(getItem(position)?.image)
                .into(binding.imvCharacter)
            item.setOnClickListener {
                AppConstants.characterSelected = getItem(position)
                item.findNavController()
                    .navigate(R.id.action_charactersFragment_to_characterFragment)
            }
        }
    }

    object CharacterDifferentiate : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }
    }
}