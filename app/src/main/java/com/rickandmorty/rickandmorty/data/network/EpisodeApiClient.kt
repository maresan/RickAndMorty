package com.rickandmorty.rickandmorty.data.network

import com.rickandmorty.rickandmorty.model.ResponseEpisode
import retrofit2.Response
import retrofit2.http.GET

interface EpisodeApiClient {
    @GET("episode")
    suspend fun getEpisodes(): Response<ResponseEpisode>
}
