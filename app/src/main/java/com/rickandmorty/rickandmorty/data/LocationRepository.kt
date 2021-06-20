package com.rickandmorty.rickandmorty.data

import com.rickandmorty.rickandmorty.data.network.LocationService
import com.rickandmorty.rickandmorty.model.ResponseLocation

class LocationRepository {
    private val api = LocationService()

    suspend fun getLocations(): ResponseLocation {
        val response = api.getLocations()
        LocationProvider.locations = response
        return response
    }
}
