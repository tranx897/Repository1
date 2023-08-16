package edu.uchicago.gerber.androidretro.presentation.screens.favorites.paging

import androidx.paging.PagingData
import edu.uchicago.gerber.androidretro.data.dto.Movie
import kotlinx.coroutines.flow.Flow

data class FavoritesSearchState(
    val favoriteSearchOperation: FavoriteSearchOperation = FavoriteSearchOperation.INITIAL,
    val data: Flow<PagingData<Movie>>? = null
)

enum class FavoriteSearchOperation { LOADING, INITIAL, DONE }