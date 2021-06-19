package com.rickandmorty.rickandmorty.domain

import com.rickandmorty.rickandmorty.data.CharacterRepository
import com.rickandmorty.rickandmorty.model.ResponseCharacter

class GetCharactersUseCase {
    private val repository = CharacterRepository()

    suspend operator fun invoke(): ResponseCharacter = repository.getCharacters()
}
