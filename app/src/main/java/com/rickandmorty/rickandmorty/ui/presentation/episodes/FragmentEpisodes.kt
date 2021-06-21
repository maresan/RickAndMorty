package com.rickandmorty.rickandmorty.ui.presentation.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.rickandmorty.rickandmorty.databinding.FragmentEpisodesBinding
import com.rickandmorty.rickandmorty.model.ResponseEpisode
import com.rickandmorty.rickandmorty.ui.viewmodel.EpisodeViewModel

class FragmentEpisodes : Fragment() {
    private lateinit var binding: FragmentEpisodesBinding
    private lateinit var adapterEpisode: AdapterEpisode
    private val episodeViewModel: EpisodeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        episodeViewModel.getAllEpisodes()
        episodeViewModel.allEpisodesModel.observe(viewLifecycleOwner, {initRecyclerView(it)})
    }

    private fun initRecyclerView(responseEpisode: ResponseEpisode) {
        adapterEpisode = AdapterEpisode(responseEpisode.results)
        binding.recyclerview.apply {
            layoutManager = GridLayoutManager(binding.root.context, 2)
            adapter = adapterEpisode
        }
    }
}
