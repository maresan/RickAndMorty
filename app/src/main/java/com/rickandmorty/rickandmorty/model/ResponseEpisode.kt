package com.rickandmorty.rickandmorty.model

import java.io.Serializable

data class ResponseEpisode(
    val info: Info,
    val results: List<Episode>
) : Serializable