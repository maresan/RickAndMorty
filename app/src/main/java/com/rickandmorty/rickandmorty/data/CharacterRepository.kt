package com.rickandmorty.rickandmorty.data

import com.rickandmorty.rickandmorty.data.network.CharacterService
import com.rickandmorty.rickandmorty.model.Character
import com.rickandmorty.rickandmorty.model.ResponseCharacter

class CharacterRepository {
    private val api = CharacterService()

    suspend fun getCharacters(): ResponseCharacter {
        val response = api.getCharacters()
        CharacterProvider.characters = response
        return response
    }

    suspend fun getCharacter(id: String): Character {
        val response = api.getCharacter(id)
        CharacterProvider.character = response
        return response
    }
}
