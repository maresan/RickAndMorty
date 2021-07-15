package com.rickandmorty.rickandmorty.ui.presentation.locationinformation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rickandmorty.rickandmorty.databinding.AdapterImageTextBinding
import com.rickandmorty.rickandmorty.model.Character
import com.squareup.picasso.Picasso

class CharacterAdapter(private val characters: MutableList<Character>): RecyclerView.Adapter<CharacterViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = AdapterImageTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.text.text = characters[position].name
        Picasso.get().load(characters[position].image).into(holder.image)
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}

class CharacterViewHolder(binding: AdapterImageTextBinding) : RecyclerView.ViewHolder(binding.root) {
    val image = binding.image
    val text = binding.text
}
