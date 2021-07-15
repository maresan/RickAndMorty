package com.rickandmorty.rickandmorty.data

import com.rickandmorty.rickandmorty.model.Character
import com.rickandmorty.rickandmorty.model.ResponseCharacter

class CharacterProvider {
    companion object {
        var characters: ResponseCharacter? = null
        var character: Character? = null
    }
}
