package com.example.starwarslistapp.data.repository

import com.example.starwarslistapp.data.network.StarWarsApi
import com.example.starwarslistapp.data.network.model.FilmPerson

class StarWarsRepository(private val starWarsApi: StarWarsApi) {

    suspend fun getPeopleList(
    ): List<FilmPerson> = try {
        starWarsApi.getPeople().results.map { it.toDomain() }
    } catch (exception: Exception) {
        // TODO Handle exceptions
        throw exception
    }

}
