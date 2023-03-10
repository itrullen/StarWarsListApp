import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.starwarslistapp.domain.model.PersonItem
import com.example.starwarslistapp.presentation.components.buttons.FavoriteButton
import com.example.starwarslistapp.presentation.theme.Purple200
import com.example.starwarslistapp.presentation.ui.people.PeopleViewModel

@Composable
fun PeopleScreenContent(viewModel: PeopleViewModel, navController: NavController) {
    val peopleList = viewModel.peopleList
    val favoritesList = viewModel.favoritesList
    val filterFavourites by viewModel.filterFavorites

    var mainList: SnapshotStateList<PersonItem>

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
        ) {
            mainList = if (filterFavourites) favoritesList else peopleList
            itemsIndexed(mainList) { index, person ->
                PeopleListItem(
                    person,
                    onClick = { navController.navigate("personDetails/${person.id}") },
                    onFavouriteChanged = {
                        viewModel.onFavouriteChanged(index, it)
                    }
                )
            }
        }

    }
}

@Composable
fun PeopleListItem(
    person: PersonItem,
    onClick: () -> Unit,
    onFavouriteChanged: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onClick() }
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            FavoriteButton(person.favorite, onFavouriteChanged)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = person.name)
        }

        Icon(
            imageVector = Icons.Filled.KeyboardArrowRight,
            tint = Purple200,
            contentDescription = null
        )
    }
}

@Composable
@Preview(showBackground = false)
private fun Preview() = PeopleListItem(
    person = PersonItem(null, "Luke Skywalker", "", "", "", "", true),
    onClick = {},
    onFavouriteChanged = {}
)