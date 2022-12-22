package com.example.starwarslistapp.data.network.model

import java.io.Serializable

data class FilmPerson(
    val name: String,
    val birthYear: String,
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    var favorite: Boolean
) : Serializable
