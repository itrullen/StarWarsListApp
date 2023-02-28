package com.example.starwarslistapp.domain

import com.example.starwarslistapp.data.database.entities.toDatabase
import com.example.starwarslistapp.data.repository.StarWarsRepository
import com.example.starwarslistapp.domain.model.PersonItem

class GetPeopleUseCase(private val starWarsRepository: StarWarsRepository) {
    suspend operator fun invoke(): List<PersonItem> {
        val people = starWarsRepository.getPeopleListFromApi()

        return if (people.isNotEmpty()) {
            starWarsRepository.clearPeople()
            starWarsRepository.insertPeople(people.map { it.toDatabase() })
            starWarsRepository.getPeopleListFromDatabase()
        } else {
            starWarsRepository.getPeopleListFromDatabase()
        }
    }
}