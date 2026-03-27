package com.example.tark_frontend_app.data.datasources.remote.parser


import com.example.tark_frontend_app.data.datasources.remote.dto.EarthquakeDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class AfadJsonParser @Inject constructor() {

    private val gson = Gson()

    fun parse(json: String): List<EarthquakeDto> {
        return try {
            val type = object : TypeToken<List<EarthquakeDto>>() {}.type
            gson.fromJson(json, type) ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }
}