import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.freetogameclone.presentation.GamesListItem
import com.example.freetogameclone.presentation.games.BrowserGamesViewModel
import com.example.freetogameclone.presentation.games.GamesViewModel

@Composable
fun BrowserGamesScreen(
    viewModel: BrowserGamesViewModel = hiltViewModel(),
) {
    val gamesList = viewModel.games().collectAsLazyPagingItems()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .background(Color(0xff121010))
    ) {
        items(gamesList.itemCount) { games ->
            gamesList[games]?.let {
                GamesListItem(gameDetails = it)
            }
        }
    }
}