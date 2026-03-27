package com.example.tark_frontend_app.domain.repositories

import com.example.tark_frontend_app.domain.models.Earthquake

interface AFADRepository {
    suspend fun getEarthquakes(): List<Earthquake>
}