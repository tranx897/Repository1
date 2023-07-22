package edu.uchicago.gerber.androidretro.data.repository

import edu.uchicago.gerber.androidretro.data.models.MovieResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

//this will manage generating the query string and using Retrofit to send GET request to api
//    @GET(value = "titles/search/keyword/{name}")
//    suspend fun getMovies(
//        @Query("q") query: String,
//        @Query("limit") limit: Int,
//        @Query("page") page: Int,
//    ): Response<MovieResponse>
    @Headers("X-RapidAPI-Key: 447b489f46msh37561d21265994fp10e718jsn0f16e5e800db",
        "X-RapidAPI-Host: moviesdatabase.p.rapidapi.com")
    @GET(value = "titles/search/keyword/{name}")
    suspend fun getMovies(
        @Path("name") name: String,
        @Query("page") page: Int
    ): Response<MovieResponse>

}