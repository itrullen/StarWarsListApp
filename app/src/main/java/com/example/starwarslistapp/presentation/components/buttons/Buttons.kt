package com.example.starwarslistapp.presentation.components.buttons

import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.starwarslistapp.presentation.theme.Purple200

@Composable
fun FavoriteButton(
    isFavorite: Boolean, onFavouriteChanged: (Boolean) -> Unit, modifier: Modifier? = Modifier
) {
    IconToggleButton(
        checked = isFavorite, onCheckedChange = onFavouriteChanged, modifier = modifier ?: Modifier
    ) {
        Icon(
            tint = Purple200,
            imageVector = if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = null,
        )
    }
}