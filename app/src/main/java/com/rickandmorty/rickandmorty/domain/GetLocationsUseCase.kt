package com.rickandmorty.rickandmorty.domain

import com.rickandmorty.rickandmorty.data.LocationRepository
import com.rickandmorty.rickandmorty.model.ResponseLocation

class GetLocationsUseCase {
    private val repository = LocationRepository()

    suspend operator fun invoke(): ResponseLocation = repository.getLocations()
}
