package com.example.starwarslistapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonDTO(
    @SerialName("name")
    val name: String,
    @SerialName("birth_year")
    val birthYear: String,
    @SerialName("eye_color")
    val eyeColor: String,
    @SerialName("gender")
    val gender: String,
    @SerialName("hair_color")
    val hairColor: String
)
