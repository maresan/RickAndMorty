package com.rickandmorty.rickandmorty.model

import java.io.Serializable

data class Location(
    val name: String,
    val link: String
) : Serializable
