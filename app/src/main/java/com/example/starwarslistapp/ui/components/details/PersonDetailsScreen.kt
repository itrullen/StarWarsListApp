package com.example.starwarslistapp.ui.components.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import com.example.starwarslistapp.ui.theme.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PersonDetailsScreen(viewModel: PersonDetailsViewModel) {
    val person = viewModel.person
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
    ) {
        Text(
            text = person.name,
            style = Typography.h1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = person.birthYear,
            style = Typography.h2
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = person.gender,
            style = Typography.h3
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = person.eyeColor,
            style = Typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = person.hairColor,
            style = Typography.body1
        )
    }
}