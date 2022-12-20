package com.example.starwarslistapp.di

import com.example.starwarslistapp.ui.components.people.PeopleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        PeopleViewModel(starWarsRepository = get())
    }

}