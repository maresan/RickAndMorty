package com.rickandmorty.rickandmorty.ui.presentation.locations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rickandmorty.rickandmorty.R
import com.rickandmorty.rickandmorty.databinding.AdapterLocationBinding
import com.rickandmorty.rickandmorty.model.Location

class AdapterLocation(private val locations: List<Location>) : RecyclerView.Adapter<LocationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding = AdapterLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.name.text = locations[position].name
        holder.type.text = holder.itemView.resources.getString(R.string.type, locations[position].type)
        holder.residentAmount.text = holder.itemView.resources.getString(R.string.residents, locations[position].residents.size.toString())
    }

    override fun getItemCount(): Int {
        return locations.size
    }
}

class LocationViewHolder(binding: AdapterLocationBinding) : RecyclerView.ViewHolder(binding.root) {
    val name = binding.name
    val type = binding.type
    val residentAmount = binding.residentsAmount
}
