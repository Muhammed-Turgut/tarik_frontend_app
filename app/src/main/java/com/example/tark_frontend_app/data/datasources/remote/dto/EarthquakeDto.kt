package com.example.tark_frontend_app.data.datasources.remote.dto

data class EarthquakeDto(
    val eventID: String?,          // nullable — AFAD HTML may not expose this
    val date: String,
    val latitude: Double?,
    val longitude: Double?,
    val depth: Double?,
    val magnitude: Double?,
    val location: String
)