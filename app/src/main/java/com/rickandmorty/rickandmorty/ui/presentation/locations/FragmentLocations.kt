package com.rickandmorty.rickandmorty.ui.presentation.locations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.rickandmorty.rickandmorty.databinding.FragmentLocationsBinding
import com.rickandmorty.rickandmorty.model.ResponseLocation
import com.rickandmorty.rickandmorty.ui.viewmodel.LocationViewModel

class FragmentLocations : Fragment() {
    private lateinit var binding: FragmentLocationsBinding

    private lateinit var adapterLocation: AdapterLocation
    private val locationViewModel: LocationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentLocationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        locationViewModel.onCreate()
        locationViewModel.locationModel.observe(viewLifecycleOwner, { initRecyclerView(it) })
    }

    private fun initRecyclerView(responseLocation: ResponseLocation) {
        adapterLocation = AdapterLocation(responseLocation.results)
        binding.recyclerview.apply {
            layoutManager = GridLayoutManager(binding.root.context, 2)
            adapter = adapterLocation
        }
    }
}
