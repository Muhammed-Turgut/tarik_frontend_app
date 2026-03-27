package com.example.tark_frontend_app.presentation.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.tark_frontend_app.domain.models.Earthquake
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapsScreen(
    earthquakes: List<Earthquake> = emptyList()
) {
    val turkey = LatLng(39.0, 35.0) // Türkiye merkezi

    val cameraState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(turkey, 6f) // zoom out — tüm TR görünsün
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraState
    ) {
        earthquakes.forEach { earthquake ->
            if (earthquake.latitude != null && earthquake.longitude != null) {
                val position = LatLng(earthquake.latitude, earthquake.longitude)
                Marker(
                    state = MarkerState(position = position),
                    title = earthquake.location,
                    snippet = "M${earthquake.magnitude} — ${earthquake.date}"
                )
            }
        }
    }
}