package com.example.starwarslistapp.ui.components.people

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.starwarslistapp.data.network.model.FilmPerson
import com.example.starwarslistapp.data.repository.StarWarsRepository
import com.example.starwarslistapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch


class PeopleViewModel(
    private val starWarsRepository: StarWarsRepository
) : BaseViewModel() {

    val peopleList = mutableStateListOf<FilmPerson>()
    val isLoading = mutableStateOf(false)

    init {
        getPeopleList()
    }

    private fun getPeopleList() = runAsync(isLoading) {
        val people = starWarsRepository.getPeopleList()
        viewModelScope.launch {
            peopleList.addAll(people)
        }
    }
}