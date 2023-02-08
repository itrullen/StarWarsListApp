package com.example.starwarslistapp.presentation.ui.people

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarslistapp.domain.GetPeopleUseCase
import com.example.starwarslistapp.domain.model.PersonItem
import kotlinx.coroutines.launch

class PeopleViewModel(
    private val getPeopleUseCase: GetPeopleUseCase
) : ViewModel() {
    val peopleList = mutableStateListOf<PersonItem>()
    val favoritesList = mutableStateListOf<PersonItem>()
    val filterFavorites = mutableStateOf(false)

    fun onCreate() {
        getPeopleList()
    }

    private fun getPeopleList() = viewModelScope.launch {
        val people = getPeopleUseCase()
        peopleList.clear()
        peopleList.addAll(people)
    }

    fun onFavouriteChanged(index: Int, value: Boolean) {
        val updatedList = peopleList.toMutableList()
        updatedList[index].favorite = value

        viewModelScope.launch {
            peopleList.clear()
            peopleList.addAll(updatedList)
        }
    }

    fun filterFavorites(enableFilter: Boolean) {
        filterFavorites.value = enableFilter

        viewModelScope.launch {
            favoritesList.clear()
            favoritesList.addAll(peopleList.filter { it.favorite })
        }
    }
}