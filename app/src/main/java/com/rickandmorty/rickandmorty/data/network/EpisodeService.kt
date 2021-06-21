package com.rickandmorty.rickandmorty.data.network

import com.rickandmorty.rickandmorty.core.RetrofitHelper
import com.rickandmorty.rickandmorty.model.ResponseEpisode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EpisodeService {
    private val retrofit = RetrofitHelper.getBaseUrl()

    suspend fun getEpisodes(): ResponseEpisode {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(EpisodeApiClient::class.java).getEpisodes()
            response.body()!!
        }
    }
}
