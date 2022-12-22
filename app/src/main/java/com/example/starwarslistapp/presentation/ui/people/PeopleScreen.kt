import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.starwarslistapp.data.network.model.FilmPerson
import com.example.starwarslistapp.presentation.components.buttons.FavoriteButton
import com.example.starwarslistapp.presentation.ui.people.PeopleFragmentDirections
import com.example.starwarslistapp.presentation.ui.people.PeopleViewModel

@Composable
fun PeopleScreenContent(viewModel: PeopleViewModel, navController: NavController) {
    val peopleList = remember { viewModel.peopleList }
    val favoritesList = remember { viewModel.favoritesList }
    val filterFavourites by viewModel.filterFavorites
    val isLoading by viewModel.isLoading

    var mainList: SnapshotStateList<FilmPerson>

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
                PeopleListItem(person,
                    onClick = {
                        navController.navigate(
                            PeopleFragmentDirections.actionPeopleFragmentToPersonDetailsFragment(
                                person
                            )
                        )
                    },
                    onFavouriteChanged = {
                        viewModel.onClickFavorite(index)
                    })
            }
        }

    }
}

@Composable
fun PeopleListItem(
    person: FilmPerson,
    onClick: () -> Unit,
    onFavouriteChanged: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onClick() }
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = person.name
        )

        FavoriteButton(person.favorite, onFavouriteChanged)
    }
}

@Composable
@Preview(showBackground = false)
private fun Preview() = PeopleListItem(
    person = FilmPerson("Luke Skywalker", "", "", "", "", true),
    onClick = {},
    onFavouriteChanged = {}
)