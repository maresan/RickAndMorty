package com.rickandmorty.rickandmorty.ui.presentation.characterinformation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
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
        holder.itemView.setOnClickListener {
            bottomSheetDialog(holder.itemView, episodes[position])
        }
    }

    override fun getItemCount(): Int {
        return episodes.size
    }

    private fun bottomSheetDialog(view: View, episode: Episode){
        val bottomSheetDialog = BottomSheetDialog(view.context)
        val bottomSheetDialogView: View = LayoutInflater.from(view.context).inflate(R.layout.bottom_sheet_episode, null)
        bottomSheetDialog.setContentView(bottomSheetDialogView)

        val name = bottomSheetDialogView.findViewById<TextView>(R.id.episode_name)
        val characters = bottomSheetDialogView.findViewById<TextView>(R.id.episode_characters)
        val airDate = bottomSheetDialogView.findViewById<TextView>(R.id.episode_air_date)
        val created = bottomSheetDialogView.findViewById<TextView>(R.id.episode_created)

        name.text = view.context.getString(R.string.episode_name, episode.episode, episode.name)
        characters.text = view.context.getString(R.string.characters_amount, episode.characters.size.toString())
        airDate.text = view.context.getString(R.string.air_date, episode.air_date)
        created.text = view.context.getString(R.string.created, episode.air_date)

        bottomSheetDialog.show()
    }
}

class EpisodesViewHolder(binding: AdapterSimpleTextBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val text = binding.text
}
