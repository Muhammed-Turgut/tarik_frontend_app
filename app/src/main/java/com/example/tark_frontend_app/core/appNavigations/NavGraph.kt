package com.example.tark_frontend_app.core.appNavigations

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tark_frontend_app.presentation.view.HomeScreen
import com.example.tark_frontend_app.presentation.view.MapsScreen
import com.example.tark_frontend_app.presentation.view.SplashScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navHostController,
        startDestination = "SplashScreen",
        modifier = modifier
            .background(color = Color(0xFFFFFFFF))
    ) {

        composable("SplashScreen") {
            SplashScreen(navHostController)
        }

        composable("HomeScreen") {
            HomeScreen()
        }

        composable("MapScreen") {
            MapsScreen()
        }
    }


}