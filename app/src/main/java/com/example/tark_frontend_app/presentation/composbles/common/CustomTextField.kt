package com.example.tark_frontend_app.presentation.composbles.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction  // ✅ Doğru import
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tark_frontend_app.R

@Composable
fun CustomTextField(onValueChange: (String) -> Unit, icon : Int, hint : String) {  // ✅ İsim düzeltildi

    var value by remember { mutableStateOf("") }  // ✅ 'text' yerine 'value'

    TextField(
        value = value,
        onValueChange = {
            value = it
            onValueChange(it)  // ✅ Dışarıya iletiliyor
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,   // focus olunca çizgi yok
            unfocusedIndicatorColor = Color.Transparent, // focus olmayınca çizgi yok
            disabledIndicatorColor = Color.Transparent,

            focusedContainerColor = Color.White,      // focus olunca
            unfocusedContainerColor = Color.White,    // focus olmayınca
            disabledContainerColor = Color.White,   // disabled durumda çizgi yok
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = Color(0xFFDBE2EF),
                shape = RoundedCornerShape(12.dp)
        ),
        label = {

            Text(hint,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.lexend_deca_regular)),
                color = Color.Black
            )

         },
        placeholder = { Text("") },
        leadingIcon = { Icon(
            painter = painterResource(id = icon),
            tint = Color.Unspecified,
            contentDescription = null
        )},
        trailingIcon = {

        },
        isError = false,
        enabled = true,
        readOnly = false,
        singleLine = false,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done  // ✅ Artık çalışır
        ),
        keyboardActions = KeyboardActions(
            onDone = { /* klavye kapat */ }
        )
    )
}