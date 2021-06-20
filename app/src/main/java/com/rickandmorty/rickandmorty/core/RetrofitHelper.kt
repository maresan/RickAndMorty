package com.rickandmorty.rickandmorty.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://rickandmortyapi.com/api/"

object RetrofitHelper {
    fun getBaseUrl(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}
