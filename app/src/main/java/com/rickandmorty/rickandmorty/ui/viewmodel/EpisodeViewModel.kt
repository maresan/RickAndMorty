package com.rickandmorty.rickandmorty.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rickandmorty.rickandmorty.domain.GetEpisodesUseCase
import com.rickandmorty.rickandmorty.model.ResponseEpisode
import kotlinx.coroutines.launch

class EpisodeViewModel : ViewModel() {
    internal val episodeModel = MutableLiveData<ResponseEpisode>()
    private val getEpisodeUseCase = GetEpisodesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result = getEpisodeUseCase()

            if (result.results.isNotEmpty()) {
                episodeModel.postValue(result)
            }
        }
    }
}
