package com.example.tark_frontend_app.domain.models

data class Earthquake(
    val date: String,          // was: history
    val location: String,
    val magnitude: Double?,    // was: intensity — nullable to match DTO
    val latitude: Double?,
    val longitude: Double?,
    val depth: Double?
)