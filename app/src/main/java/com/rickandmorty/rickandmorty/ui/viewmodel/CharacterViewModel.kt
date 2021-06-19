package com.rickandmorty.rickandmorty.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rickandmorty.rickandmorty.domain.GetCharactersUseCase
import com.rickandmorty.rickandmorty.model.ResponseCharacter
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    internal val characterModel = MutableLiveData<ResponseCharacter>()
    private val getCharacterUseCase = GetCharactersUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result = getCharacterUseCase()

            if (result.results.isNotEmpty()) {
                characterModel.postValue(result)
            }
        }
    }
}
