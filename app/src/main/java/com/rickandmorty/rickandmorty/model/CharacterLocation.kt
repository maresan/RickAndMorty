package com.rickandmorty.rickandmorty.model

import java.io.Serializable

data class CharacterLocation(
    val name: String,
    val link: String
) : Serializable
