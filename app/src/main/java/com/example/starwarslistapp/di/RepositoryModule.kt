package com.example.starwarslistapp.di

import com.example.starwarslistapp.data.repository.StarWarsRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    single { StarWarsRepository(starWarsApi = get(), get(named("personDAO"))) }
}