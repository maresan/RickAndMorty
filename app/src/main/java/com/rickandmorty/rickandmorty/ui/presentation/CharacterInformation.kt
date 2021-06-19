package com.rickandmorty.rickandmorty.ui.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.rickandmorty.rickandmorty.R
import com.rickandmorty.rickandmorty.databinding.ActivityCharacterInformationBinding
import com.rickandmorty.rickandmorty.model.Character
import com.squareup.picasso.Picasso

private const val CHARACTER_INFO = "characterInformation"

class CharacterInformation : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterInformationBinding
    private lateinit var characterInformation: Character

    override fun onBackPressed() {
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        characterInformation = intent.extras?.get(CHARACTER_INFO) as Character
        initActionBar(characterInformation.name)
        initView(characterInformation)
    }

    private fun initActionBar(name: String) {
        val actionBar = supportActionBar
        actionBar?.let {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = name
            actionBar.elevation = 0.0f
        }
    }

    private fun initView(characterInformation: Character) {
        Picasso.get().load(characterInformation.image).into(binding.image)

        if (characterInformation.status.isNotEmpty()) {
            binding.status.text = getString(R.string.status, characterInformation.status)
            binding.status.visibility = View.VISIBLE
        }

        if (characterInformation.species.isNotEmpty()) {
            binding.species.text = getString(R.string.species, characterInformation.species)
            binding.species.visibility = View.VISIBLE
        }

        if (characterInformation.type.isNotEmpty()) {
            binding.type.text = getString(R.string.type, characterInformation.type)
            binding.type.visibility = View.VISIBLE
        }

        if (characterInformation.gender.isNotEmpty()) {
            binding.gender.text = getString(R.string.gender, characterInformation.gender)
            binding.gender.visibility = View.VISIBLE
        }

        if (characterInformation.origin.name.isNotEmpty()) {
            binding.origin.text = getString(R.string.origin, characterInformation.origin.name)
            binding.origin.visibility = View.VISIBLE
        }

        if (characterInformation.location.name.isNotEmpty()) {
            binding.location.text = getString(R.string.location, characterInformation.location.name)
            binding.location.visibility = View.VISIBLE
        }
    }
}
