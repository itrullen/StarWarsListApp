package com.example.starwarslistapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StarWarsElementDTO<T>(
    @SerialName("results")
    val results: List<T>
)
