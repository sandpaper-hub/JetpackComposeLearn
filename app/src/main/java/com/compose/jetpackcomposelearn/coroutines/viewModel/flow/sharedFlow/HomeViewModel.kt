package com.compose.jetpackcomposelearn.coroutines.viewModel.flow.sharedFlow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _navEvents = MutableSharedFlow<UiEvent>()
    val navEvents: SharedFlow<UiEvent> = _navEvents

    fun onNavigateClick() {
        viewModelScope.launch {
            _navEvents.emit(UiEvent.NavigateToDetails)
        }
    }

    sealed class UiEvent {
        object NavigateToDetails : UiEvent()
    }
}