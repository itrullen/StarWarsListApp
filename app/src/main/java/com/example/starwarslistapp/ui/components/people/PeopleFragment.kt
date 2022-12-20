package com.example.starwarslistapp.ui.components.people

import PeopleScreenContent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.example.starwarslistapp.ui.base.BaseFragment
import com.example.starwarslistapp.ui.theme.StarWarsListAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class PeopleFragment : BaseFragment() {

    private val viewModel: PeopleViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
        )
        setContent {
            StarWarsListAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PeopleScreenContent(viewModel= viewModel)
                }
            }
        }
    }
}