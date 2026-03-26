package com.example.tark_frontend_app.presentation.composbles.common.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tark_frontend_app.R
import com.example.tark_frontend_app.presentation.composbles.common.CustomButton

@Composable
fun CriticalLocationsElement(
    title: String,
    onClick: () -> Unit,
    distance: String,
    icon : Int,
    color: Color) {

    Column(modifier = Modifier.fillMaxWidth()) {

        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(color.copy(alpha = 0.35f))){
                Image(painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp))
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column() {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.lexend_deca_semi_bold)),
                    color = Color.Black
                )

                Text(
                    text = distance,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.lexend_deca_light)),
                    color = Color.Black
                )
            }

        }

        Spacer(modifier = Modifier.height(8.dp))

        CustomButton(
            text = "Yol Tarifi",
            onClick = {
                onClick()
            },
            containerColor = Color(0xFFDBEDF3),
            textColor = Color.Black
        )

    }
}