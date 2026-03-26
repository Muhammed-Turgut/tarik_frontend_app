package com.example.tark_frontend_app.presentation.composbles.common.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tark_frontend_app.R
import com.example.tark_frontend_app.presentation.composbles.common.CustomButton

@Composable
fun LiveAnnouncements() {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(8.dp))
        .background(color = Color(0xFFF1F4F6))
        .fillMaxWidth()
        .padding(12.dp)){

        Column(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start) {

                Image(painter = painterResource(R.drawable.announcement_icon),
                    contentDescription = null)

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Canlı Duyurular",
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.lexend_deca_semi_bold)),
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = "AFAD ve yerel yönetimlerden gelen son\n" +
                        "dakika uyarıları.",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.lexend_deca_light)),
                color = Color(0xFF3E484C),
                textAlign = TextAlign.Start,
                lineHeight = 14.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            CustomButton(
                text = "Tümünü Gör",
                onClick = {

                },
                containerColor = Color(0xFFE6E9EA),
                textColor = Color(0xFF3E484C)
            )

        }
    }

}