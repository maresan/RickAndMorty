package com.rickandmorty.rickandmorty.data.network

import com.rickandmorty.rickandmorty.core.RetrofitHelper
import com.rickandmorty.rickandmorty.model.Character
import com.rickandmorty.rickandmorty.model.ResponseCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterService {
    private val retrofit = RetrofitHelper.getBaseUrl()

    suspend fun getCharacters(): ResponseCharacter {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CharacterApiClient::class.java).getCharacters()
            response.body()!!
        }
    }

    suspend fun getCharacter(id: String): Character {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(CharacterApiClient::class.java).getCharacter(id)
            response.body()!!
        }
    }
}
