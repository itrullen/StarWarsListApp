package com.example.starwarslistapp.data.repository

import com.example.starwarslistapp.data.database.dao.PersonDAO
import com.example.starwarslistapp.data.database.entities.PersonEntity
import com.example.starwarslistapp.data.network.StarWarsApi
import com.example.starwarslistapp.domain.model.PersonItem
import com.example.starwarslistapp.domain.model.toDomain

class StarWarsRepository(
    private val starWarsApi: StarWarsApi,
    private val personDAO: PersonDAO
) {

    suspend fun getPeopleListFromApi(
    ): List<PersonItem> = try {
        starWarsApi.getPeople().results.map { it.toDomain() }
    } catch (exception: Exception) {
        emptyList()
    }

    suspend fun getPeopleListFromDatabase(): List<PersonItem> =
        personDAO.getAllPeople().map { it.toDomain() }

    suspend fun insertPeople(people: List<PersonEntity>) {
        personDAO.insertAll(people)
    }

    suspend fun clearPeople() {
        personDAO.deleteAllPeople()
    }
}
