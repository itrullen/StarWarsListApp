package com.example.starwarslistapp.presentation.ui.people

import FavoritesAppBar
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.example.starwarslistapp.R
import com.example.starwarslistapp.presentation.theme.StarWarsListAppTheme
import com.example.starwarslistapp.presentation.ui.NavigationComposable
import org.koin.androidx.viewmodel.ext.android.viewModel

class PeopleActivity : AppCompatActivity() {

    private val viewModel: PeopleViewModel by viewModel()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            StarWarsListAppTheme(darkTheme = false) {
                Scaffold(
                    topBar = {
                        FavoritesAppBar(title = stringResource(id = R.string.app_name),
                            filterFavorite = viewModel.filterFavorites.value,
                            onClickButton = { viewModel.filterFavorites(it) })
                    }, content = {
                        NavigationComposable(navController = navController, viewModel)
                    }
                )
            }
        }
    }
}

