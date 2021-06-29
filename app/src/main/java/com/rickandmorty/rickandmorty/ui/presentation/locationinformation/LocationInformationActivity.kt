package com.rickandmorty.rickandmorty.ui.presentation.locationinformation

import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.rickandmorty.rickandmorty.R
import com.rickandmorty.rickandmorty.databinding.ActivityLocationInformationBinding
import com.rickandmorty.rickandmorty.model.Character
import com.rickandmorty.rickandmorty.model.Location
import com.rickandmorty.rickandmorty.ui.viewmodel.CharacterViewModel

private const val LOCATION_INFO = "location_info"

class LocationInformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLocationInformationBinding
    private val characterViewModel: CharacterViewModel by viewModels()
    private lateinit var adapterCharacter: CharacterAdapter
    private val listOfCharacters: MutableList<Character> = mutableListOf()
    private lateinit var locationInformation: Location

    override fun onBackPressed() {
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        locationInformation = intent.extras?.get(LOCATION_INFO) as Location
        initActionBar()
        initView()
        getCharacters()
    }

    private fun initActionBar() {
        val actionBar = supportActionBar
        actionBar?.let {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = getString(R.string.location)
        }
    }

    private fun initView() {
        binding.locationName.text = getString(R.string.name, locationInformation.name)
        binding.locationType.text = getString(R.string.type, locationInformation.type)
        binding.locationDimension.text =
            getString(R.string.dimension, locationInformation.dimension)
        binding.locationCreated.text = getString(R.string.created, locationInformation.created)
        binding.locationResidents.text =
            getString(R.string.residents, locationInformation.residents.size.toString())
    }

    private fun getCharacters() {
        for (character in locationInformation.residents) {
            characterViewModel.getCharacter(Uri.parse(character).lastPathSegment!!)
        }
        characterViewModel.characterModel.observe(this, {
            listOfCharacters.add(it)
            initRecyclerView(listOfCharacters)
        })
    }

    private fun initRecyclerView(characters: MutableList<Character>) {
        adapterCharacter = CharacterAdapter(characters)
        binding.recyclerview.apply {
            layoutManager = GridLayoutManager(this.context, 3)
            adapter = adapterCharacter
        }
    }
}
