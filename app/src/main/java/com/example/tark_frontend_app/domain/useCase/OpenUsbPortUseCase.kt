package com.example.tark_frontend_app.domain.useCase

import android.content.Context
import com.example.tark_frontend_app.domain.repositories.UsbPortRepository
import javax.inject.Inject

class OpenUsbPortUseCase @Inject constructor(
    private val usbPortRepository: UsbPortRepository
) {

    suspend fun openUsbPort(context: Context){
        usbPortRepository.openUsbPort(context)
    }

}