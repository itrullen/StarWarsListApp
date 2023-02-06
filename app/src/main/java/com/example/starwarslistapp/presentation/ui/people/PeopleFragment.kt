package com.example.starwarslistapp.presentation.ui.people

import FavoritesAppBar
import PeopleScreenContent
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.starwarslistapp.R
import com.example.starwarslistapp.presentation.theme.StarWarsListAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class PeopleFragment : Fragment() {

    private val viewModel: PeopleViewModel by viewModel()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
        )
        setContent {
            StarWarsListAppTheme(darkTheme = false) {
                Scaffold(topBar = {
                    FavoritesAppBar(title = stringResource(id = R.string.app_name),
                        filterFavorite = viewModel.filterFavorites.value,
                        onClickButton = { viewModel.filterFavorites(it) })
                }, content = {
                    PeopleScreenContent(viewModel = viewModel, findNavController())
                })
            }
        }
    }
}