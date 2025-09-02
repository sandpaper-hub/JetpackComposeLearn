package com.compose.jetpackcomposelearn.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel() : ViewModel() {
    private val _screenUiState = MutableStateFlow(TextState("Input something..."))
    private val _mainScreenState = MutableStateFlow<MainScreenState>(MainScreenState.Success)
    val screenUiState: StateFlow<TextState> = _screenUiState
    val mainScreenState: StateFlow<MainScreenState> = _mainScreenState


    fun changeText(changedText: String) {
        viewModelScope.launch {
            _mainScreenState.value = MainScreenState.LoadingState
            delay(5000)
            _screenUiState.value = _screenUiState.value.copy(text = changedText)
            _mainScreenState.value = MainScreenState.Success
        }
    }
}

data class TextState(
    val text: String = ""
)

sealed interface MainScreenState {
    data object LoadingState: MainScreenState
    data object Success: MainScreenState
}