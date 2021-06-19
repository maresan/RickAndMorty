package com.rickandmorty.rickandmorty.ui.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rickandmorty.rickandmorty.databinding.ActivityCharacterInformationBinding
import com.rickandmorty.rickandmorty.model.Character

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

        characterInformation = intent.extras?.get("characterInformation") as Character
        initActionBar(characterInformation.name)
    }

    private fun initActionBar(name: String) {
        val actionBar = supportActionBar
        actionBar?.let {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = name
            actionBar.elevation = 0.0f
        }
    }
}
