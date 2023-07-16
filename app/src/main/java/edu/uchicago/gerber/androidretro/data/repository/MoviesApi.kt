package edu.uchicago.gerber.androidretro.data.repository

import edu.uchicago.gerber.androidretro.data.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

//this will manage generating the query string and using Retrofit to send GET request to api
    @GET(value = "auto-complete")
    suspend fun getBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int,
        @Query("startIndex") startIndex: Int,
    ): Response<MovieResponse>

}