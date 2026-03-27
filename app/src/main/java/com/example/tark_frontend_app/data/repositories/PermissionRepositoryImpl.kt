package com.example.tark_frontend_app.data.repositories

import android.content.Context
import com.example.tark_frontend_app.data.datasources.usbPort.USBPort
import com.example.tark_frontend_app.domain.repositories.PermissionRepository
import javax.inject.Inject

class PermissionRepositoryImpl @Inject constructor(
    private val usbPort: USBPort
) : PermissionRepository {
    override suspend fun RequestUSBPermission(context: Context): Boolean {
        return  usbPort.requestUsbPermission(context)
    }
}