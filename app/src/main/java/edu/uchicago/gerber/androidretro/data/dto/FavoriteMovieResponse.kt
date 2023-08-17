package edu.uchicago.gerber.androidretro.data.dto

import edu.uchicago.gerber.androidretro.data.models.Result
import org.json.JSONArray

data class FavoriteMovieResponse (
    var movies: List<Movie>
) {
    companion object {
        fun movieArray2FMR(movieArray: Array<Movie>): FavoriteMovieResponse {
            return FavoriteMovieResponse(movies = movieArray.toList())
        }
    }
}