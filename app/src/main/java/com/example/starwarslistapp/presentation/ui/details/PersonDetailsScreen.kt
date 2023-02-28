package com.example.starwarslistapp.presentation.ui.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.starwarslistapp.domain.model.PersonItem
import com.example.starwarslistapp.presentation.theme.Typography

@Composable
fun PersonDetailsScreen(person: PersonItem) {
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
            text = "Year of Birth: ${person.birthYear}",
            style = Typography.h2
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Gender: ${person.gender}",
            style = Typography.h3
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Eye Color: ${person.eyeColor}",
            style = Typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Hair Color: ${person.hairColor}",
            style = Typography.body1
        )
    }
}