package edu.uchicago.gerber.androidretro.data.repository

import com.google.gson.JsonObject
import edu.uchicago.gerber.androidretro.data.dto.Email
import edu.uchicago.gerber.androidretro.data.models.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Response

class SamEmailerRepository (private val samEmailerApi: SamEmailerApi) {

    suspend fun sendEmail(email: JsonObject): Response<Any> {
        return withContext(Dispatchers.IO) {
            samEmailerApi.sendEmail(email)
        }
    }
}
