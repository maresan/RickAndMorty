package com.rickandmorty.rickandmorty.domain

import com.rickandmorty.rickandmorty.data.EpisodeRepository
import com.rickandmorty.rickandmorty.model.ResponseEpisode

class GetEpisodesUseCase {
    private val repository = EpisodeRepository()

    suspend operator fun invoke(): ResponseEpisode = repository.getEpisodes()
}
