package edu.uchicago.gerber.androidretro.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.uchicago.gerber.androidretro.presentation.screens.contact.ContactScreen
import edu.uchicago.gerber.androidretro.presentation.screens.details.DetailsScreen
import edu.uchicago.gerber.androidretro.presentation.screens.favorites.FavoritesScreen
import edu.uchicago.gerber.androidretro.presentation.screens.search.SearchScreen
import edu.uchicago.gerber.androidretro.presentation.viewmodels.MovieViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    movieViewModel: MovieViewModel = viewModel()
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
            DetailsScreen()
        }
    }
}