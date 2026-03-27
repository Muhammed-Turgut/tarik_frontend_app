package com.example.tark_frontend_app.core.di

import com.example.tark_frontend_app.data.repositories.PermissionRepositoryImpl
import com.example.tark_frontend_app.data.repositories.UsbPortRepositoryImpl
import com.example.tark_frontend_app.domain.repositories.PermissionRepository
import com.example.tark_frontend_app.domain.repositories.UsbPortRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUsbPortRepository(
        impl: UsbPortRepositoryImpl
    ): UsbPortRepository

    @Binds
    @Singleton
    abstract fun bindUsbPermissionRepository(
        impl: PermissionRepositoryImpl
    ): PermissionRepository

}