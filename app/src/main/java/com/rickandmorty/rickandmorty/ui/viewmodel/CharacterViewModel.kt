package com.rickandmorty.rickandmorty.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rickandmorty.rickandmorty.domain.GetCharactersUseCase
import com.rickandmorty.rickandmorty.model.Character
import com.rickandmorty.rickandmorty.model.ResponseCharacter
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    internal val allCharactersModel = MutableLiveData<ResponseCharacter>()
    internal val characterModel = MutableLiveData<Character>()

    private val getAllCharactersUseCase = GetCharactersUseCase()
    private val getCharacterUseCase = GetCharactersUseCase()

    fun getAllCharacters() {
        viewModelScope.launch {
            val result = getAllCharactersUseCase()

            if (result.results.isNotEmpty()) {
                allCharactersModel.postValue(result)
            }
        }
    }

    fun getCharacter(id: String) {
        viewModelScope.launch {
            val result = getCharacterUseCase(id)

            if (result.name.isNotEmpty()) {
                characterModel.postValue(result)
            }
        }
    }
}
