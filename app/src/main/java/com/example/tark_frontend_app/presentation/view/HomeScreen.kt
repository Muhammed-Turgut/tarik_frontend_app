package com.example.tark_frontend_app.presentation.view

import android.R.attr.strokeWidth
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tark_frontend_app.R
import com.example.tark_frontend_app.presentation.composbles.common.CustomButton
import com.example.tark_frontend_app.presentation.composbles.common.CustomTextField
import com.example.tark_frontend_app.presentation.composbles.common.home.CriticalLocationsElement
import com.example.tark_frontend_app.presentation.composbles.common.home.LiveAnnouncements
import kotlinx.coroutines.flow.sample
import java.nio.file.Files.size

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    ){


    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.PartiallyExpanded // başlangıçta yarı açık ✅
        )
    )

    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetPeekHeight = 124.dp, // ✅ her zaman bu kadar açık kalır
        sheetContainerColor = Color.White,
        containerColor = Color(0xFFF9F7F7),
        sheetContentColor = Color.White,
        sheetDragHandle = null,
        sheetContent = {
            //İÇERİK KISMI
            DetailsPanel()
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            AppBar()
            MapsScreen()

        }
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsPanel(

) {
    Column(modifier = Modifier.fillMaxWidth()) {

        // Drag handle + başlık
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .width(64.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(color = Color(0xFFDBE2EF))
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(onValueChange = { text ->

            },
            icon = R.drawable.location_icon,
            hint = "Lütfen Hedef Konum Girin...")

            Spacer(modifier = Modifier.height(12.dp))

            CustomButton(
                text = "Konumu Ara",
                onClick = {

                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            LiveAnnouncements()

            Spacer(modifier = Modifier.height(24.dp))

            CriticalLocations()





        }


    }

}

@Composable
fun AppBar() {
 Row(modifier = Modifier.fillMaxWidth()) {
   Row(modifier = Modifier
       .fillMaxWidth()
       .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)) {

       Column() {

           Image(painter = painterResource(R.drawable.app_logo),
               contentDescription = null,
               colorFilter = ColorFilter.tint(Color(0xFF419EBD)),
               modifier = Modifier.size(width = 84.dp, height = 26.dp))

           Text(
               text = "Afet Müdhale Sistemi",
               fontSize = 8.sp,
               fontFamily = FontFamily(Font(R.font.lexend_deca_light)),
               color = Color.Black,
               lineHeight = 8.sp
           )
       }
   }
 }
}

@Composable
fun CriticalLocations() {

    Column(modifier = Modifier.fillMaxWidth()) {

        CriticalLocationsElement(
            title = "Toplanma Alan",
            distance = "400 Metre",
            onClick = {

            },
            icon = R.drawable.assembly_area_icon,
            color = Color(0xFF419EBF)
        )

        Spacer(modifier = Modifier.height(12.dp))

        CriticalLocationsElement(
            title = "Sığnak",
            distance = "450 Metre",
            onClick = {

            },
            icon = R.drawable.shelter_icon,
            color = Color(0xFF4AE42C)
        )

        Spacer(modifier = Modifier.height(12.dp))

        CriticalLocationsElement(
            title = "Hastane",
            distance = "1000 Metre",
            onClick = {

            },
            icon = R.drawable.hospital_icon,
            color = Color(0xFFB81D27)
        )
    }


}


@Preview(showBackground = true)
@Composable
private fun ShowView(){
    HomeScreen()
}