package com.compose.jetpackcomposelearn.modifierPack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorExample() {
    val newColor = Color(0xFF22A45D)
    Text("New color!", modifier = Modifier.background(newColor).padding(30.dp))
}