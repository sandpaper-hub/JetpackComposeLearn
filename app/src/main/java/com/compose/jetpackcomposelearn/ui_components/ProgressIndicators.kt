package com.compose.jetpackcomposelearn.ui_components

import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
@Suppress("FunctionName")
fun CircularProgressIndicatorExample() {
    var progress by remember { mutableFloatStateOf(0f) }
    val scope = rememberCoroutineScope()
    Button(onClick = {
        if (progress >= 1f) progress = 0f
        scope.launch {
            while (progress < 1f) {
                progress += 0.1f
                delay(1000L)
            }
        }
    }) {
        Text("Start")
    }
    CircularProgressIndicator(progress = { progress })
}