package edu.uchicago.gerber.androidretro.data.repository

import edu.uchicago.gerber.androidretro.data.dto.Email
import edu.uchicago.gerber.androidretro.data.models.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Response

class SamEmailerRepository (private val samEmailerApi: SamEmailerApi) {

    suspend fun sendEmail(email: JSONObject): Response<JSONObject> {
        return withContext(Dispatchers.IO) {
            samEmailerApi.sendEmail(email)
        }
    }
}
