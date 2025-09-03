package com.compose.jetpackcomposelearn.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel() : ViewModel() {
    private val _mainUiState = MutableStateFlow(MainUiState("Input something..."))
    val mainScreenUiState: StateFlow<MainUiState> = _mainUiState

    fun changeText(changedText: String) {
        viewModelScope.launch {
            _mainUiState.value = _mainUiState.value.copy(isLoading = true)
            delay(5000)
            _mainUiState.value = _mainUiState.value.copy(text = changedText, isLoading = false)
        }
    }
}

data class MainUiState(
    val text: String = "",
    val isLoading: Boolean = false
)