package com.rickandmorty.rickandmorty.ui.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.rickandmorty.rickandmorty.R
import com.rickandmorty.rickandmorty.databinding.ActivityMainBinding
import com.rickandmorty.rickandmorty.ui.presentation.characters.FragmentCharacters
import com.rickandmorty.rickandmorty.ui.presentation.episodes.FragmentEpisodes
import com.rickandmorty.rickandmorty.ui.presentation.locations.FragmentLocations
import com.rickandmorty.rickandmorty.ui.presentation.profile.FragmentProfile

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val fragmentCharacters = FragmentCharacters()
    private val fragmentLocations = FragmentLocations()
    private val fragmentEpisodes = FragmentEpisodes()
    private val fragmentProfile = FragmentProfile()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCurrentFragment(fragmentCharacters)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_characters -> setCurrentFragment(fragmentCharacters)
                R.id.navigation_locations -> setCurrentFragment(fragmentLocations)
                R.id.navigation_episodes -> setCurrentFragment(fragmentEpisodes)
                R.id.navigation_profile -> setCurrentFragment(fragmentProfile)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}
