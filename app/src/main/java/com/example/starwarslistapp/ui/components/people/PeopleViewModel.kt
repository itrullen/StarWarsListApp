package com.example.starwarslistapp.ui.components.people

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.viewModelScope
import com.example.starwarslistapp.data.network.model.FilmPerson
import com.example.starwarslistapp.data.repository.StarWarsRepository
import com.example.starwarslistapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch


class PeopleViewModel(
    private val starWarsRepository: StarWarsRepository
) : BaseViewModel() {

    val peopleList = mutableStateListOf<FilmPerson>()

    init {
        getPeopleList()
    }

    private fun getPeopleList() = runAsync {
        viewModelScope.launch {
            peopleList.addAll(starWarsRepository.getPeopleList())
        }
    }

}