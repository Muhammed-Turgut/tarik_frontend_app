package com.example.tark_frontend_app.data.datasources.remote.source

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class AfadRemoteDataSource @Inject constructor() {

    companion object {
        private const val BASE_URL =
            "https://deprem.afad.gov.tr/apiv2/event/filter"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun fetchJson(): String = withContext(Dispatchers.IO) {
        val today = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val start = "${today.format(formatter)}T00:00:00"
        val end   = "${today.format(formatter)}T23:59:59"

        val url = "$BASE_URL?start=$start&end=$end&orderby=timedesc"
        URL(url).readText()
    }
}