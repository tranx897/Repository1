package edu.uchicago.gerber.androidretro.data.dto

import edu.uchicago.gerber.androidretro.data.models.Result
import org.json.JSONObject

data class Movie (
    var id: String,
    var title:String,
    var imageUrl:String,
    var year:String,
)
{
    companion object {
        fun result2Movie(result: Result): Movie {
            return Movie(
                id = "",
                title = result.titleText.text ?: "",
                imageUrl = result.primaryImage?.url ?: "https://picsum.photos/id/1026/60/90",
                year = result.releaseYear.toString() ?: "None"
            )
        }

        fun fromJson(jsonObject: JSONObject): Movie {
            val id = jsonObject.getString("id")
            val title = jsonObject.getString("title")
            val imageUrl = jsonObject.getString("imageUrl")
            val year = jsonObject.getString("year")
            return Movie(id, title, imageUrl, year)
        }
    }

    fun toJsonRaw(): JSONObject {
        val map = mutableMapOf<Any?, Any?>()
        map["title"] = title
        map["imageUrl"] = imageUrl
        map["year"] = year
        return JSONObject(map)

    }

    fun toJson(): JSONObject {
        val jsonObject: JSONObject = toJsonRaw()
        jsonObject.put("id", id)
        return jsonObject

    }
}