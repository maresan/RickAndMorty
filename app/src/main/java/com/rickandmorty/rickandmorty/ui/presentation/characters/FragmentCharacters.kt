package com.rickandmorty.rickandmorty.ui.presentation.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rickandmorty.rickandmorty.databinding.FragmentCharactersBinding
import com.rickandmorty.rickandmorty.model.ResponseCharacter
import com.rickandmorty.rickandmorty.ui.viewmodel.CharacterViewModel

class FragmentCharacters : Fragment() {
    private lateinit var binding: FragmentCharactersBinding

    private lateinit var adapterCharacters: AdapterCharacters
    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characterViewModel.onCreate()
        characterViewModel.characterModel.observe(viewLifecycleOwner, { initRecyclerView(it) })
    }

    private fun initRecyclerView(responseCharacter: ResponseCharacter) {
        adapterCharacters = AdapterCharacters(responseCharacter.results)
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(binding.root.context)
            adapter = adapterCharacters
        }
    }
}
