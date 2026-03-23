package com.example.tark_frontend_app.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tark_frontend_app.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(Unit) {
        delay(3000) // 3 saniye
        navController.navigate("HomeScreen") {
            popUpTo("SplashScreen") { inclusive = true }
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color= Color(0xFF419EBD))
    ){


        Image(
            painter = painterResource(R.drawable.spalsh_screen_companent),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop  // veya ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(painter = painterResource(R.drawable.app_logo),
                contentDescription = null,
                modifier = Modifier.size(144.dp, 44.dp)
                )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Afet bölgelerinde kurtarma ekiplerine anlık,\ngüvenli rota rehberliği.",
                fontSize = 12.sp,
                color = Color.White,
                lineHeight = 16.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.lexend_deca_light)))


        }


    }
}