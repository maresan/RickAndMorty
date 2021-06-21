package com.rickandmorty.rickandmorty.domain

import com.rickandmorty.rickandmorty.data.EpisodeRepository
import com.rickandmorty.rickandmorty.model.Episode
import com.rickandmorty.rickandmorty.model.ResponseEpisode

class GetEpisodesUseCase {
    private val repository = EpisodeRepository()

    suspend operator fun invoke(): ResponseEpisode = repository.getAllEpisodes()
    suspend operator fun invoke(episodeNumber: String): Episode = repository.getEpisode(episodeNumber)
}
