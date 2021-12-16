package com.axell.marvelcharacters.features.characters.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.axell.marvelcharacters.databinding.CharacterRowBinding
import com.axell.marvelcharacters.features.characters.modelview.CharacterView

class CharacterAdapter(
    private val characters: List<CharacterView>,
    private val listener: CharacterListener
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    interface CharacterListener {
        fun characterSelected(character: CharacterView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            CharacterRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bindCharacter(character, listener)
    }

    override fun getItemCount(): Int = characters.size

    inner class CharacterViewHolder(private val binding: CharacterRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var character: CharacterView? = null

        fun bindCharacter(character: CharacterView, listener: CharacterListener) {
            this.character = character

            binding.tvHeroName.text = character.name
            binding.ivHeroPicture.load(character.thumbnail)
            binding.root.setOnClickListener {
                listener.characterSelected(character)
            }
        }
    }
}
