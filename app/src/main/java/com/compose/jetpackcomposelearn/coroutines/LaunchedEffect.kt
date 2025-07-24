package com.compose.jetpackcomposelearn.coroutines

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
@Suppress("FunctionName")
fun EffectDemo(modifier: Modifier) {
    var message by remember { mutableStateOf("Downloading...") }
    LaunchedEffect(Unit) {
        delay(1000)
        message = "Data has been downloaded successful"
    }

    SideEffect {
        Log.d("ExampleTest", "Component re-rendered with message: $message")
    }

    Box(
        modifier = modifier.then(
            Modifier
                .fillMaxSize()
        ),
        contentAlignment = Alignment.Center
    ) {
        Text(message)
    }
}