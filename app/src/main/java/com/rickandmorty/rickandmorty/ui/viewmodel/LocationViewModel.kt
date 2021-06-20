package com.rickandmorty.rickandmorty.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rickandmorty.rickandmorty.domain.GetLocationsUseCase
import com.rickandmorty.rickandmorty.model.ResponseLocation
import kotlinx.coroutines.launch

class LocationViewModel : ViewModel() {
    internal val locationModel = MutableLiveData<ResponseLocation>()
    private val getLocationsUseCase = GetLocationsUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result = getLocationsUseCase()

            if (result.results.isNotEmpty()) {
                locationModel.postValue(result)
            }
        }
    }
}
