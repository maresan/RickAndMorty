package com.rickandmorty.rickandmorty.data

import com.rickandmorty.rickandmorty.data.network.EpisodeService
import com.rickandmorty.rickandmorty.model.ResponseEpisode

class EpisodeRepository {
    private val api = EpisodeService()

    suspend fun getEpisodes(): ResponseEpisode {
        val response = api.getEpisodes()
        EpisodeProvider.episodes = response
        return response
    }
}
