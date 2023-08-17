package edu.uchicago.gerber.androidretro.data.repository

import edu.uchicago.gerber.androidretro.data.dto.Email
import edu.uchicago.gerber.androidretro.data.dto.FavoriteMovieResponse
import edu.uchicago.gerber.androidretro.data.dto.Movie
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SamEmailerApi {

    @POST(value = "mail")
    suspend fun sendEmail(
        @Body newEmail: JSONObject
    ): Response<JSONObject>

}