package com.example.tark_frontend_app.data.repositories

import android.content.Context
import com.example.tark_frontend_app.data.datasources.usbPort.USBPort
import com.example.tark_frontend_app.domain.repositories.UsbPortRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsbPortRepositoryImpl @Inject constructor(
    private val usbPort: USBPort
) : UsbPortRepository {

    override suspend fun openUsbPort(activityContext: Context) {
        usbPort.openUsbPort()
    }

}