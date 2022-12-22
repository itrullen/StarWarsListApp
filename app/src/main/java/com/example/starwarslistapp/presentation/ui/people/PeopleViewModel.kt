package com.example.starwarslistapp.presentation.ui.people

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.starwarslistapp.data.network.model.FilmPerson
import com.example.starwarslistapp.data.repository.StarWarsRepository
import com.example.starwarslistapp.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class PeopleViewModel(
    private val starWarsRepository: StarWarsRepository
) : BaseViewModel() {
    val peopleList = mutableStateListOf<FilmPerson>()
    val favoritesList = mutableStateListOf<FilmPerson>()
    val filterFavorites = mutableStateOf(false)
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

    fun onClickFavorite(index: Int) {
        val temporaryList: MutableList<FilmPerson> =
            emptyList<FilmPerson>().toMutableList()
        temporaryList.addAll(peopleList)
        temporaryList[index].favorite = !peopleList[index].favorite
        viewModelScope.launch {
            peopleList.clear()
            peopleList.addAll(temporaryList)
        }
    }

    fun filterFavorites(enableFilter: Boolean) {
        filterFavorites.value = enableFilter
        val temporaryList: MutableList<FilmPerson> =
            emptyList<FilmPerson>().toMutableList()
        temporaryList.addAll(peopleList)
        val list = temporaryList.filter { it.favorite }
        viewModelScope.launch {
            favoritesList.clear()
            favoritesList.addAll(list)
        }
    }
}