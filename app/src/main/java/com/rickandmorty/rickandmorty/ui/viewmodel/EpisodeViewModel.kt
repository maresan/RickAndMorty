package com.rickandmorty.rickandmorty.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rickandmorty.rickandmorty.domain.GetEpisodesUseCase
import com.rickandmorty.rickandmorty.model.Episode
import com.rickandmorty.rickandmorty.model.ResponseEpisode
import kotlinx.coroutines.launch

class EpisodeViewModel : ViewModel() {
    internal val allEpisodesModel = MutableLiveData<ResponseEpisode>()
    internal val episodeModel = MutableLiveData<Episode>()

    private val getAllEpisodesUseCase = GetEpisodesUseCase()
    private val getEpisodeUseCase = GetEpisodesUseCase()

    fun getAllEpisodes() {
        viewModelScope.launch {
            val result = getAllEpisodesUseCase()

            if (result.results.isNotEmpty()) {
                allEpisodesModel.postValue(result)
            }
        }
    }

    fun getEpisode(episodeNumber: String) {
        viewModelScope.launch {
            val result = getEpisodeUseCase(episodeNumber)

            if (result.name.isNotEmpty()){
                episodeModel.postValue(result)
            }
        }
    }
}
