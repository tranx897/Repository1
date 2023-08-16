package edu.uchicago.gerber.androidretro.data.dto

import org.json.JSONObject

data class Email (
    var email:String,
    var subject: String,
    var body:String,
)
{
    companion object {
        fun string2Email(email: String, subject: String, body: String): Email {
            return Email(
                email = email,
                subject = subject,
                body = body
            )
        }

        fun fromJson(jsonObject: JSONObject): Email {
            val email = jsonObject.getString("email")
            val subject = jsonObject.getString("subject")
            val body = jsonObject.getString("body")
            return Email(email, subject, body)
        }
    }

    fun toJsonRaw(): JSONObject {
        val map = mutableMapOf<Any?, Any?>()
        map["email"] = email
        map["subject"] = subject
        map["body"] = body
        return JSONObject(map)

    }

}