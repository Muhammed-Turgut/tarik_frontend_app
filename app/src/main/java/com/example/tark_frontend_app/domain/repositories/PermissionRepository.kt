package com.example.tark_frontend_app.domain.repositories

import android.content.Context

interface PermissionRepository {
    suspend fun RequestUSBPermission(context: Context) : Boolean
}