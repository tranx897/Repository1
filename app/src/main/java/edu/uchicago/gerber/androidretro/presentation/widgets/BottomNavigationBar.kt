package edu.uchicago.gerber.androidretro.presentation.widgets

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import edu.uchicago.gerber.androidretro.presentation.navigation.Screen
import edu.uchicago.gerber.androidretro.presentation.viewmodels.MovieViewModel

@Composable
fun BottomNavigationBar(movieViewModel: MovieViewModel, navController: NavController) {
    val tabs = listOf(
        Screen.Search,
        Screen.Favorites,
        Screen.Contact
    )
    NavigationBar(
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        tabs.forEach { tab ->
            NavigationBarItem(
                icon = { Icon(painterResource(id = tab.icon), contentDescription = tab.title) },
                label = { Text(text = tab.title) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Blue,
                    selectedTextColor = Color.Blue,
                    unselectedIconColor = Color.Blue.copy(0.4f),
                    unselectedTextColor = Color.Blue.copy(0.4f)
                ),
                alwaysShowLabel = true,
                selected = currentRoute == tab.route,
                onClick = {
                    if (tab == Screen.Favorites) {
                        movieViewModel.onFavoriteSearch()
                    }

                    navController.navigate(tab.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // re-selecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}