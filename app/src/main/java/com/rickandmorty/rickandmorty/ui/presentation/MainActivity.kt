package com.rickandmorty.rickandmorty.ui.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rickandmorty.rickandmorty.databinding.ActivityMainBinding
import com.rickandmorty.rickandmorty.model.ResponseCharacter
import com.rickandmorty.rickandmorty.ui.viewmodel.CharacterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterCharacters: AdapterCharacters
    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        characterViewModel.onCreate()
        characterViewModel.characterModel.observe(this, { initRecyclerView(it) })
    }

    private fun initRecyclerView(responseCharacter: ResponseCharacter) {
        adapterCharacters = AdapterCharacters(responseCharacter.results)
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(binding.root.context)
            adapter = adapterCharacters
        }
    }
}
