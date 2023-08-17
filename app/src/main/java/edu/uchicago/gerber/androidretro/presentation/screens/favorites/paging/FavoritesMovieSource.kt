package edu.uchicago.gerber.androidretro.presentation.screens.favorites.paging

import android.app.Activity
import android.widget.Toast
import androidx.paging.PagingSource
import androidx.paging.PagingState
import edu.uchicago.gerber.androidretro.data.dto.Movie
import edu.uchicago.gerber.androidretro.data.repository.FavoriteMoviesRepository


class FavoritesMovieSource (
    private val favoriteMoviesRepository: FavoriteMoviesRepository,
    private val paginateData : FavoritesPaginate,
) :
    PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPageNumber = params.key ?: 0

            val response = favoriteMoviesRepository.getFavoriteMovies(page = nextPageNumber)
            if (response.isSuccessful) {
                val movieList: List<Movie>? = response.body()

                LoadResult.Page(
                    data = movieList!!,
                    prevKey = if (nextPageNumber == 0) null else nextPageNumber - 1,
                    nextKey = nextPageNumber + 1
                )
            } else {
                val errorMessage = "Error: ${response.code()} - ${response.message()}"
                LoadResult.Error(Exception(response.message()))
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override val keyReuseSupported: Boolean
        get() = true

}

