package edu.uchicago.gerber.androidretro.presentation.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import edu.uchicago.gerber.androidretro.common.Constants
import edu.uchicago.gerber.androidretro.presentation.screens.search.paging.MovieList
import edu.uchicago.gerber.androidretro.presentation.screens.search.paging.MovieRow
import edu.uchicago.gerber.androidretro.presentation.screens.search.paging.SearchOperation
import edu.uchicago.gerber.androidretro.presentation.viewmodels.MovieViewModel
import edu.uchicago.gerber.androidretro.presentation.widgets.BottomNavigationBar
import edu.uchicago.gerber.androidretro.presentation.widgets.CustomOutlinedTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    movieViewModel: MovieViewModel,
    navController: NavController,
) {
    val state = movieViewModel.searchState.value
    val queryText = movieViewModel.queryText.value

    Scaffold(
        modifier = Constants.modifier,
        bottomBar = { BottomNavigationBar(navController) },
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {
                    Text(
                        text = "Search Books",
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )

                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            CustomOutlinedTextField(
                title = "Search term(s)",
                placeHolder = "e.g. java",
                textState = queryText,
                onTextChange = movieViewModel::setQueryText,
                keyboardType = KeyboardType.Text,
                ImeAction.Search,
                movieViewModel::onSearch
            )

            Spacer(modifier = Modifier.height(10.dp))
            when (state.searchOperation) {
                SearchOperation.LOADING -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(12.dp)
                                .align(
                                    Alignment.Center
                                )
                        )
                    }
                }
                SearchOperation.DONE -> {
                    MovieList(movieViewModel, navController)
                }
                else -> {
                    Box {}
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SearchScreenPreview(movieViewModel: MovieViewModel = MovieViewModel(), navController: NavController = NavController()) {
//    SearchScreen(movieViewModel = movieViewModel, navController = navController)
//}
