package com.rickandmorty.rickandmorty.ui.presentation.locations

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rickandmorty.rickandmorty.R
import com.rickandmorty.rickandmorty.databinding.AdapterLocationBinding
import com.rickandmorty.rickandmorty.model.Location
import com.rickandmorty.rickandmorty.ui.presentation.locationinformation.LocationInformationActivity

private const val LOCATION_INFO = "location_info"

class AdapterLocation(private val locations: List<Location>) :
    RecyclerView.Adapter<LocationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding =
            AdapterLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.name.text = locations[position].name
        holder.type.text =
            holder.itemView.resources.getString(R.string.type, locations[position].type)
        holder.residentAmount.text = holder.itemView.resources.getString(
            R.string.residents,
            locations[position].residents.size.toString()
        )
        holder.itemView.setOnClickListener {
            goToLocationInformation(holder.itemView.context, locations[position])
        }
    }

    override fun getItemCount(): Int {
        return locations.size
    }

    private fun goToLocationInformation(context: Context, location: Location) {
        val intent = Intent(context, LocationInformationActivity::class.java).apply {
            putExtra(LOCATION_INFO, location)
        }
        context.startActivity(intent)
    }
}

class LocationViewHolder(binding: AdapterLocationBinding) : RecyclerView.ViewHolder(binding.root) {
    val name = binding.name
    val type = binding.type
    val residentAmount = binding.residentsAmount
}
