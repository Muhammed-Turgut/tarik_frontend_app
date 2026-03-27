package com.example.tark_frontend_app.domain.useCase

import com.example.tark_frontend_app.domain.models.Earthquake
import com.example.tark_frontend_app.domain.repositories.AFADRepository
import javax.inject.Inject

class AFADLastEarthquakeUseCase @Inject constructor(
     private val afadRepository: AFADRepository
) {

    suspend fun getEarthquakes(): List<Earthquake>{
      return  afadRepository.getEarthquakes()
    }

}