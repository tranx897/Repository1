package edu.uchicago.gerber.androidretro.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import edu.uchicago.gerber.androidretro.presentation.screens.contact.ContactScreen
import edu.uchicago.gerber.androidretro.presentation.screens.details.DetailsScreen
import edu.uchicago.gerber.androidretro.presentation.screens.favorites.FavoritesScreen
import edu.uchicago.gerber.androidretro.presentation.screens.search.SearchScreen
import edu.uchicago.gerber.androidretro.presentation.viewmodels.MovieViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(
    movieViewModel: MovieViewModel = viewModel(),
    navController: NavHostController,
) {

    NavHost(navController, startDestination = Screen.Search.route) {
        composable(Screen.Search.route) {
            SearchScreen(movieViewModel,navController)

        }
        composable(Screen.Favorites.route) {
            FavoritesScreen(navController)
        }

        composable(Screen.Contact.route) {
            ContactScreen(navController)
        }

        composable(Screen.Detail.route) {
            DetailsScreen(movieViewModel, navController)
        }
    }
}