package com.shevchenkovtwo.rickmortyapp.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shevchenkovtwo.rickmortyapp.AppConstants
import com.shevchenkovtwo.rickmortyapp.R
import com.shevchenkovtwo.rickmortyapp.model.Character
import com.shevchenkovtwo.rickmortyapp.databinding.ListViewCharacterItemBinding

class CharactersAdapter(private var context: Context, private var charactersList: List<Character>) :
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {
    class ViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        val binding = ListViewCharacterItemBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.list_view_character_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.tvCharacterName.text = charactersList[position].name
            binding.tvCharacterStatus.text = charactersList[position].status
            Glide.with(context)
                .load(charactersList[position].image)
                .into(binding.imvCharacter)
            item.setOnClickListener {
                AppConstants.characterSelected = charactersList[position]
                item.findNavController()
                    .navigate(R.id.action_charactersFragment_to_characterFragment)
            }
        }
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
}