package com.example.tark_frontend_app.data.repositories

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.tark_frontend_app.data.datasources.remote.parser.AfadJsonParser
import com.example.tark_frontend_app.data.datasources.remote.source.AfadRemoteDataSource
import com.example.tark_frontend_app.domain.models.Earthquake
import com.example.tark_frontend_app.domain.repositories.AFADRepository
import javax.inject.Inject

class AFADRepositoryImpl @Inject constructor(
    private val afadRemoteDataSource: AfadRemoteDataSource,
    private val parser: AfadJsonParser          // HtmlParser → JsonParser
) : AFADRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getEarthquakes(): List<Earthquake> {
        val json = afadRemoteDataSource.fetchJson()   // 1. JSON'ı çek
        val dtoList = parser.parse(json)              // 2. Parse et → DTO listesi

        return dtoList.map { dto ->                   // 3. DTO → Domain model
            Earthquake(
                date      = dto.date.orEmpty(),
                location  = dto.location.orEmpty(),
                magnitude = dto.magnitude,
                latitude  = dto.latitude,
                longitude = dto.longitude,
                depth     = dto.depth
            )
        }
    }
}