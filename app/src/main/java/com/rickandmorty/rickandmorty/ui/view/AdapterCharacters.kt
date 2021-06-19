package com.rickandmorty.rickandmorty.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rickandmorty.rickandmorty.databinding.AdapterCharactersBinding
import com.rickandmorty.rickandmorty.model.Character
import com.squareup.picasso.Picasso

class AdapterCharacters(private val characters: List<Character>) :
    RecyclerView.Adapter<CharactersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val binding =
            AdapterCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharactersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.name.text = characters[position].name
        holder.specie.text = characters[position].species
        holder.gender.text = characters[position].gender
        Picasso.get().load(characters[position].image).into(holder.photo)
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}

class CharactersViewHolder(binding: AdapterCharactersBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val name = binding.name
    val photo = binding.photo
    val specie = binding.specie
    val gender = binding.gender
}
