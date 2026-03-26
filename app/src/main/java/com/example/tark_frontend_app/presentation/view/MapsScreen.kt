package com.example.tark_frontend_app.presentation.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polygon
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapsScreen() {
    val istanbul = LatLng(41.0082, 28.9784)

    val cameraState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(istanbul, 12f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraState
    ) {

        // 📍 Marker (başlangıç noktası)
        Marker(
            state = MarkerState(position = istanbul),
            title = "İstanbul"
        )

        // 🔴 Riskli / kapalı yol (AI çıktısı gibi)
        Polyline(
            points = listOf(
                LatLng(41.0082, 28.9784),
                LatLng(41.0150, 28.9900)
            ),
            color = Color.Red,
            width = 8f
        )

        // 🟡 Riskli alan (enkaz bölgesi gibi)
        Polygon(
            points = listOf(
                LatLng(41.0100, 28.9700),
                LatLng(41.0200, 28.9700),
                LatLng(41.0200, 28.9800),
                LatLng(41.0100, 28.9800)
            ),
            fillColor = Color(0x44FFFF00), // yarı saydam sarı
            strokeColor = Color.Yellow,
            strokeWidth = 2f
        )

        // 🟢 Güvenli rota (senin algoritman)
        Polyline(
            points = listOf(
                LatLng(41.0082, 28.9784),
                LatLng(41.0050, 28.9650),
                LatLng(41.0000, 28.9600)
            ),
            color = Color.Green,
            width = 10f
        )
    }
}