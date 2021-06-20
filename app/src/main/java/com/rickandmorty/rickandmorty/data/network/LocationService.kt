package com.rickandmorty.rickandmorty.data.network

import com.rickandmorty.rickandmorty.core.RetrofitHelper
import com.rickandmorty.rickandmorty.model.ResponseLocation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocationService {
    private val retrofit = RetrofitHelper.getBaseUrl()

    suspend fun getLocations(): ResponseLocation {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(LocationsApiClient::class.java).getLocations()
            response.body()!!
        }
    }
}
