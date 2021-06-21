package com.rickandmorty.rickandmorty.ui.presentation.characterinformation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rickandmorty.rickandmorty.R
import com.rickandmorty.rickandmorty.databinding.AdapterSimpleTextBinding
import com.rickandmorty.rickandmorty.model.Episode

class ListOfEpisodesAdapter(private val episodes: MutableList<Episode>) :
    RecyclerView.Adapter<EpisodesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder {
        val binding =
            AdapterSimpleTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        holder.text.text = holder.itemView.resources.getString(R.string.episode_name, episodes[position].episode, episodes[position].name)
    }

    override fun getItemCount(): Int {
        return episodes.size
    }
}

class EpisodesViewHolder(binding: AdapterSimpleTextBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val text = binding.text
}
