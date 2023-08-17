package edu.uchicago.gerber.androidretro.data.repository

import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SamEmailerApi {

    @POST(value = "mail")
    suspend fun sendEmail(
        @Body newEmail: JsonObject
    ): Response<Any>

}