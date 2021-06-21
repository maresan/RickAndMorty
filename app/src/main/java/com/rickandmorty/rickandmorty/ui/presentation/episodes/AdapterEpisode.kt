package com.rickandmorty.rickandmorty.ui.presentation.episodes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rickandmorty.rickandmorty.R
import com.rickandmorty.rickandmorty.databinding.AdapterEpisodeBinding
import com.rickandmorty.rickandmorty.model.Episode

class AdapterEpisode(private val episodes: List<Episode>): RecyclerView.Adapter<EpisodeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val binding = AdapterEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.name.text = holder.itemView.resources.getString(R.string.episode_name, episodes[position].name, episodes[position].episode)
        holder.airDate.text = episodes[position].air_date
        holder.charactersAmount.text = holder.itemView.resources.getString(R.string.characters_amount, episodes[position].characters.size.toString())
    }

    override fun getItemCount(): Int {
        return episodes.size
    }
}

class EpisodeViewHolder(binding: AdapterEpisodeBinding) : RecyclerView.ViewHolder(binding.root) {
    val name = binding.name
    val airDate = binding.airDate
    val charactersAmount = binding.charactersAmount
}
