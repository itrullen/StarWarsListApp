package com.example.starwarslistapp.presentation.ui.people

import com.example.starwarslistapp.domain.GetPeopleUseCase
import com.example.starwarslistapp.domain.model.PersonItem
import com.google.common.truth.Truth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class PeopleViewModelTest {
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: PeopleViewModel

    @Mock
    private lateinit var getPeopleUseCase: GetPeopleUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = PeopleViewModel(getPeopleUseCase)
    }


    @Test
    fun `filterFavorites should only show favorite people`() = runTest {
        //given
        viewModel.peopleList.addAll(
            listOf(
                PersonItem(
                    name = "Luke Skywalker",
                    birthYear = "UUDD",
                    eyeColor = "blue",
                    gender = "male",
                    hairColor = "red",
                    favorite = true
                ), PersonItem(
                    name = "Dark Vather",
                    birthYear = "2022",
                    eyeColor = "grey",
                    gender = "male",
                    hairColor = "black",
                    favorite = false
                )
            )
        )

        //when
        viewModel.filterFavorites(true)
        advanceUntilIdle()

        //Then
        val expected = listOf(
            PersonItem(
                name = "Luke Skywalker",
                birthYear = "UUDD",
                eyeColor = "blue",
                gender = "male",
                hairColor = "red",
                favorite = true
            )
        )

        Truth.assertThat(viewModel.favoritesList).isEqualTo(expected)
    }
}