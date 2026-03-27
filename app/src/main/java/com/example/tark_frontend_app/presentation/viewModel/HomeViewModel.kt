package com.example.tark_frontend_app.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tark_frontend_app.domain.models.Earthquake
import com.example.tark_frontend_app.domain.useCase.AFADLastEarthquakeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val afadLastEarthquakeUseCase: AFADLastEarthquakeUseCase
) : ViewModel() {

    // UI State
    sealed class UiState {
        object Loading : UiState()
        data class Success(val earthquakes: List<Earthquake>) : UiState()
        data class Error(val message: String) : UiState()
    }

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        getEarthquakes()
    }

    fun getEarthquakes() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val result = afadLastEarthquakeUseCase.getEarthquakes()
                _uiState.value = UiState.Success(result)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Bilinmeyen hata")
            }
        }
    }


}