package com.rickandmorty.rickandmorty.data.network

import com.rickandmorty.rickandmorty.model.ResponseCharacter
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApiClient {
    @GET("character")
    suspend fun getCharacters(): Response<ResponseCharacter>
}
