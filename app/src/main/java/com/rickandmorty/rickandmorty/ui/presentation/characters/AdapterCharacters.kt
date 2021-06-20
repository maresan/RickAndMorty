package com.rickandmorty.rickandmorty.ui.presentation.characters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rickandmorty.rickandmorty.R
import com.rickandmorty.rickandmorty.databinding.AdapterCharactersBinding
import com.rickandmorty.rickandmorty.model.Character
import com.rickandmorty.rickandmorty.ui.presentation.characterinformation.CharacterInformation
import com.squareup.picasso.Picasso

private const val CHARACTER_INFO = "characterInformation"

class AdapterCharacters(private val characters: List<Character>) : RecyclerView.Adapter<CharactersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val binding = AdapterCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharactersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.name.text = characters[position].name
        holder.species.text = holder.itemView.resources.getString(R.string.species, characters[position].species)
        holder.gender.text = holder.itemView.resources.getString(R.string.gender, characters[position].gender)
        Picasso.get().load(characters[position].image).into(holder.photo)

        holder.itemView.setOnClickListener {
            goToCharacterInformation(holder.itemView.context, characters[position])
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    private fun goToCharacterInformation(context: Context, character: Character) {
        val intent = Intent(context, CharacterInformation::class.java).apply {
            putExtra(CHARACTER_INFO, character)
        }
        context.startActivity(intent)
    }
}

class CharactersViewHolder(binding: AdapterCharactersBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val name = binding.name
    val photo = binding.photo
    val species = binding.species
    val gender = binding.gender
}
