import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.starwarslistapp.data.network.model.FilmPerson
import com.example.starwarslistapp.ui.components.people.PeopleFragmentDirections
import com.example.starwarslistapp.ui.components.people.PeopleViewModel
import com.example.starwarslistapp.ui.utils.LoadingAnimation

@Composable
fun PeopleScreenContent(viewModel: PeopleViewModel, navController: NavController) {
    val peopleList = remember { viewModel.peopleList }
    val isLoading by viewModel.isLoading

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (isLoading) {
            LoadingAnimation()
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(White)
            ) {
                itemsIndexed(peopleList) { _, person ->
                    PeopleListItem(person,
                        onClick = {
                            navController.navigate(
                                PeopleFragmentDirections.actionPeopleFragmentToPersonDetailsFragment(
                                    person
                                )
                            )
                        }, onAddFavourite = {

                        })
                }
            }
        }
    }
}

@Composable
fun PeopleListItem(
    person: FilmPerson,
    onClick: () -> Unit,
    onAddFavourite: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onClick() }
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = person.name
        )

        IconButton(onClick = onAddFavourite) {
        }
    }
}


@Composable
@Preview(showBackground = false)
private fun Preview() = PeopleListItem(
    person = FilmPerson("Luke Skywalker", "", "", "", ""),
    onClick = {},
    onAddFavourite = {}
)