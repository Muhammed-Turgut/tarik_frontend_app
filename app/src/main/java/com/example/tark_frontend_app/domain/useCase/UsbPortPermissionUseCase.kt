package com.example.tark_frontend_app.domain.useCase

import android.content.Context
import com.example.tark_frontend_app.domain.repositories.PermissionRepository
import javax.inject.Inject

class UsbPortPermissionUseCase @Inject constructor(
    private val permissionRepository: PermissionRepository
) {
    suspend fun RequestUSBPermission(context: Context): Boolean {
        return  permissionRepository.RequestUSBPermission(context)
    }
}