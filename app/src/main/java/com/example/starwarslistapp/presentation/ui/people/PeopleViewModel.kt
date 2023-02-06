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

    init {
        getPeopleList()
    }

    private fun getPeopleList() =
        viewModelScope.launch {
            val people = getPeopleUseCase()
            peopleList.addAll(people)
        }

    fun onClickFavorite(index: Int) {
        val temporaryList: MutableList<PersonItem> =
            emptyList<PersonItem>().toMutableList()
        temporaryList.addAll(peopleList)
        temporaryList[index].favorite = !peopleList[index].favorite
        viewModelScope.launch {
            peopleList.clear()
            peopleList.addAll(temporaryList)
        }
    }

    fun filterFavorites(enableFilter: Boolean) {
        filterFavorites.value = enableFilter
        val temporaryList: MutableList<PersonItem> =
            emptyList<PersonItem>().toMutableList()
        temporaryList.addAll(peopleList)
        val list = temporaryList.filter { it.favorite }
        viewModelScope.launch {
            favoritesList.clear()
            favoritesList.addAll(list)
        }
    }
}