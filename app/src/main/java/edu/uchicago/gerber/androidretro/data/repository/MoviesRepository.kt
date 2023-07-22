package edu.uchicago.gerber.androidretro.data.repository

import edu.uchicago.gerber.androidretro.data.models.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class MoviesRepository (private val moviesApi: MoviesApi) {

    //this must be called on a background thread b/c it is long-running
    //here, I pass in the parameters I need, which then re-pass to the instantated interface
    suspend fun getMovies( name: String, page: Int): Response<MovieResponse> {
        return withContext(Dispatchers.IO) {
            moviesApi.getMovies( name, page)
        }
    }
}
