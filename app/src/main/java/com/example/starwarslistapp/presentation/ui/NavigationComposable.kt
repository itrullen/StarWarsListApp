package com.example.starwarslistapp.presentation.ui

import PeopleScreenContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.starwarslistapp.presentation.ui.details.PersonDetailsScreen
import com.example.starwarslistapp.presentation.ui.people.PeopleViewModel

@Composable
fun NavigationComposable(
    navController: NavHostController,
    viewModel: ViewModel
) {
    NavHost(navController = navController, startDestination = "peopleList") {
        composable("peopleList") {
            PeopleScreenContent(viewModel as PeopleViewModel, navController)
        }
        composable(
            "personDetails/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { backStackEntry ->
            val personId = backStackEntry.arguments?.getLong("id") ?: return@composable
            val person =
                (viewModel as PeopleViewModel).getPersonFromId(personId) ?: return@composable
            PersonDetailsScreen(person)
        }
    }
}