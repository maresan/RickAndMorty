package com.rickandmorty.rickandmorty.data.network

import com.rickandmorty.rickandmorty.model.ResponseLocation
import retrofit2.Response
import retrofit2.http.GET

interface LocationsApiClient {
    @GET("location")
    suspend fun getLocations(): Response<ResponseLocation>
}
