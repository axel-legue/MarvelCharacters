package com.axell.marvelcharacters.ui.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.axell.marvelcharacters.data.model.Character
import com.axell.marvelcharacters.databinding.CharacterRowBinding

class CharacterAdapter(
    private val characters: List<Character>,
    private val listener: CharacterListener
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    interface CharacterListener {
        fun characterSelected(character: Character)
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
        private var character: Character? = null

        fun bindCharacter(character: Character, listener: CharacterListener) {
            this.character = character

            binding.tvHeroName.text = character.name
            binding.root.setOnClickListener {
                listener.characterSelected(character)
            }
        }
    }
}
