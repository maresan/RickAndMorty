package com.rickandmorty.rickandmorty.ui.presentation.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rickandmorty.rickandmorty.databinding.FragmentEpisodesBinding

class FragmentEpisodes : Fragment() {

    private lateinit var binding: FragmentEpisodesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        return binding.root
    }
}
