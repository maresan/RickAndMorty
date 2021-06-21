package com.rickandmorty.rickandmorty.data.network

import com.rickandmorty.rickandmorty.model.Episode
import com.rickandmorty.rickandmorty.model.ResponseEpisode
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeApiClient {
    @GET("episode")
    suspend fun getAllEpisodes(): Response<ResponseEpisode>

    @GET("episode/{episodeNumber}")
    suspend fun getEpisode(@Path(value = "episodeNumber") episodeNumber: String): Response<Episode>
}
