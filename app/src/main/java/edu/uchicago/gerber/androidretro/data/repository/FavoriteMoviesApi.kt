package edu.uchicago.gerber.androidretro.data.repository

import edu.uchicago.gerber.androidretro.data.dto.FavoriteMovieResponse
import edu.uchicago.gerber.androidretro.data.dto.Movie
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FavoriteMoviesApi {

//this will manage generating the query string and using Retrofit to send GET request to api
//    @GET(value = "titles/search/keyword/{name}")
//    suspend fun getMovies(
//        @Query("q") query: String,
//        @Query("limit") limit: Int,
//        @Query("page") page: Int,
//    ): Response<MovieResponse>

    @GET(value = "/movies/paged/{page}")
    suspend fun getFavoriteMovies(
        @Path("page") page: Int
    ): Response<FavoriteMovieResponse>

    @GET(value = "/movies/{id}")
    suspend fun getFavoriteMovie(
        @Path("id") id: String
    ): Response<Movie>

    @POST(value = "/movies")
    suspend fun postFavoriteMovie(
        @Body newFavoriteMovie: Movie
    ): Response<Movie>

    @DELETE(value = "movies/{id}")
    suspend fun deleteFavoriteMovie(
        @Path("id") id: String
    ): Response<Movie>

}