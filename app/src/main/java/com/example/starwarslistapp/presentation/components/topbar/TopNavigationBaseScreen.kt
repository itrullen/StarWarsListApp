import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.starwarslistapp.R
import com.example.starwarslistapp.presentation.components.buttons.FavoriteButton
import com.example.starwarslistapp.presentation.theme.Typography

@Composable
fun TopNavigationBaseScreen(
    onBackPressed: (() -> Unit)? = null,
    title: String? = null,
    filterFavorite: Boolean = false,
    onClickButton: ((Boolean) -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)

                ) {
                    onBackPressed?.let {
                        IconButton(
                            onClick = onBackPressed,
                            modifier = Modifier
                                .size(24.dp)
                                .align(alignment = Alignment.CenterStart)
                        ) {
                            val painter = painterResource(id = R.drawable.ic_arrow_back)
                            Icon(painter = painter, contentDescription = null, tint = Color.White)
                        }
                    } ?: Spacer(modifier = Modifier.height(24.dp))

                    title?.let {
                        Text(
                            text = it,
                            style = Typography.body1.copy(
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            ),
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    onClickButton?.let {
                        FavoriteButton(
                            filterFavorite,
                            it,
                            modifier = Modifier.align(Alignment.CenterEnd)
                        )
                    }
                }
            }
            content()
        }
    }
}

