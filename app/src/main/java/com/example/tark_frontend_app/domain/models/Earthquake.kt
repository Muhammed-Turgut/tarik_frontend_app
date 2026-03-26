package com.example.tark_frontend_app.domain.models

data class Earthquake(
    val history: String,
    val location: String,
    val intensity: String,
    val latitude: String,
    val longitude: String,
    val depth: String
)