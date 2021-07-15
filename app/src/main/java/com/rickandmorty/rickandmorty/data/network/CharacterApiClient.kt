package com.rickandmorty.rickandmorty.data.network

import com.rickandmorty.rickandmorty.model.Character
import com.rickandmorty.rickandmorty.model.ResponseCharacter
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiClient {
    @GET("character")
    suspend fun getCharacters(): Response<ResponseCharacter>

    @GET("character/{id}")
    suspend fun getCharacter(@Path(value = "id") id: String): Response<Character>
}
