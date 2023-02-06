package com.example.starwarslistapp.di

import com.example.starwarslistapp.domain.GetPeopleUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetPeopleUseCase(starWarsRepository = get()) }
}