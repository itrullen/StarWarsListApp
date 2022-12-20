package com.example.starwarslistapp.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmPersonDTO(
    @SerialName("name")
    val name: String
)
