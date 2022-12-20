package com.example.starwarslistapp.data.repository

import com.example.starwarslistapp.data.network.model.FilmPerson
import com.example.starwarslistapp.data.network.model.FilmPersonDTO

fun FilmPersonDTO.toDomain(): FilmPerson {
    return FilmPerson(
        name = name
    )
}
