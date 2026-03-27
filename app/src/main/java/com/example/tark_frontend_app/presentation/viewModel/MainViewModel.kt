package com.example.tark_frontend_app.presentation.viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tark_frontend_app.domain.useCase.OpenUsbPortUseCase
import com.example.tark_frontend_app.domain.useCase.UsbPortPermissionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val openUsbPortUseCase: OpenUsbPortUseCase,
    private val usbPortPermissionUseCase: UsbPortPermissionUseCase
) : ViewModel() {


    fun requestUsbPermission(activityContext: Context) {

        viewModelScope.launch {
            val granted = usbPortPermissionUseCase.RequestUSBPermission(context = activityContext)

            if (granted) {
                Toast.makeText(activityContext, "İzin Verildi", Toast.LENGTH_SHORT).show()
                openUsbPort(activityContext)
                //startListening()
            } else {
                Toast.makeText(activityContext, "izin verilmedi", Toast.LENGTH_SHORT).show()
            }
        }

    }

    suspend fun openUsbPort(activityContext : Context) {
        openUsbPortUseCase.openUsbPort(activityContext)
    }

}