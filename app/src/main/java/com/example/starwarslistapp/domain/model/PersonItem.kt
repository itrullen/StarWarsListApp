package com.example.starwarslistapp.domain.model

import com.example.starwarslistapp.data.database.entities.PersonEntity
import com.example.starwarslistapp.data.model.PersonDTO
import java.io.Serializable

data class PersonItem(
    val name: String,
    val birthYear: String,
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    var favorite: Boolean
) : Serializable

fun PersonDTO.toDomain(): PersonItem {
    return PersonItem(
        name = name,
        birthYear = birthYear,
        eyeColor = eyeColor,
        gender = gender,
        hairColor = hairColor,
        favorite = false
    )
}

fun PersonEntity.toDomain(): PersonItem {
    return PersonItem(
        name = name,
        birthYear = birthYear,
        eyeColor = eyeColor,
        gender = gender,
        hairColor = hairColor,
        favorite = favorite
    )
}