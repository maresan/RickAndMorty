package com.rickandmorty.rickandmorty.data

import com.rickandmorty.rickandmorty.model.Episode
import com.rickandmorty.rickandmorty.model.ResponseEpisode

class EpisodeProvider {
    companion object {
        var episodes: ResponseEpisode? = null
        var episode: Episode? = null
    }
}
