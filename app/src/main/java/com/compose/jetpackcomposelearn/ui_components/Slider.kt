package com.compose.jetpackcomposelearn.ui_components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
@Suppress("FunctionName")
fun SliderExample() {
    var volume by remember { mutableFloatStateOf(50f) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Volume: ${volume.toInt()}")
        Slider(
            value = volume,
            onValueChange = { volume = it},
            valueRange = 0f..100f
        )
    }
}