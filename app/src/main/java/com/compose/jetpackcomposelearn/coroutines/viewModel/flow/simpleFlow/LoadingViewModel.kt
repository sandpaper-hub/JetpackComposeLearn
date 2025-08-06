package com.compose.jetpackcomposelearn.coroutines.viewModel.flow.simpleFlow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.jetpackcomposelearn.coroutines.ui.flow.simpleFlow.LoadingProgressData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class LoadingViewModel : ViewModel() {
    private val _status = MutableStateFlow("Push to start")
    private val _progress = MutableStateFlow(0f)
    val status: StateFlow<String> = _status
    val progress: StateFlow<Float> = _progress

    fun startLoading() {
        viewModelScope.launch {
            loadingFlow().collect { data ->
                _status.value = data.message
                _progress.value = data.progress
            }
        }
    }

    private fun loadingFlow(): Flow<LoadingProgressData> = flow {
        var progressValue = 0f
        (0..10).forEach { a ->
            emit(LoadingProgressData("Progress is: ${a * 10}%", progressValue))
            progressValue += 0.1f
            delay(1000)
        }
        emit(LoadingProgressData("Progress complete!", progressValue))
    }
}