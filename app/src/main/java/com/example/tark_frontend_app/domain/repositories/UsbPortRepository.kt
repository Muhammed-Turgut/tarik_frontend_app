package com.example.tark_frontend_app.domain.repositories

import android.content.Context

interface UsbPortRepository {
    suspend fun openUsbPort(activityContext : Context)
}