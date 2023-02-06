package com.example.starwarslistapp.presentation.ui.details

import FavoritesAppBar
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.starwarslistapp.presentation.theme.StarWarsListAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PersonDetailsFragment : Fragment() {

    private val args: PersonDetailsFragmentArgs by navArgs()
    private val viewModel: PersonDetailsViewModel by viewModel { parametersOf(args) }

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
                    FavoritesAppBar(
                        onBackPressed = { findNavController().navigateUp() }, title = "Details"
                    )
                }, content = {
                    PersonDetailsScreen(viewModel = viewModel)
                })
            }
        }
    }
}