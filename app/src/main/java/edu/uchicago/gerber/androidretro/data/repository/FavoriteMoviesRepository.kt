package edu.uchicago.gerber.androidretro.data.repository

import edu.uchicago.gerber.androidretro.data.dto.FavoriteMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class FavoriteMoviesRepository (private val favoriteMoviesApi: FavoriteMoviesApi) {

    //this must be called on a background thread b/c it is long-running
    //here, I pass in the parameters I need, which then re-pass to the instantated interface
    suspend fun getFavoriteMovies(page: Int): Response<FavoriteMovieResponse> {
        return withContext(Dispatchers.IO) {
            favoriteMoviesApi.getFavoriteMovies(page)
        }
    }
}
