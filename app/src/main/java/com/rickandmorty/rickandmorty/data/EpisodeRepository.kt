package com.rickandmorty.rickandmorty.data

import com.rickandmorty.rickandmorty.data.network.EpisodeService
import com.rickandmorty.rickandmorty.model.Episode
import com.rickandmorty.rickandmorty.model.ResponseEpisode

class EpisodeRepository {
    private val api = EpisodeService()

    suspend fun getAllEpisodes(): ResponseEpisode {
        val response = api.getAllEpisodes()
        EpisodeProvider.episodes = response
        return response
    }

    suspend fun getEpisode(episodeNumber: String): Episode {
        val response = api.getEpisode(episodeNumber)
        EpisodeProvider.episode = response
        return response
    }
}
