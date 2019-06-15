package com.github.nata01.lifetracker

import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.nio.charset.Charset

class RequestService {

    fun makeRequest(userLocationDto: UserLocationDto, cb: (String) -> Unit) {
        var gson = Gson()
        var details = gson.toJson(userLocationDto)
        val request = Request.Builder()
            .url("http://192.168.0.103:8080/users/current/locations")
            .post(RequestBody.create(MediaType.parse("application/json"), details))
            .build()

        val httpClient = OkHttpClient()
        httpClient.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val res = response.body()!!.bytes().toString(Charset.defaultCharset())
                cb(res)
            }

        })
    }
}




