package com.compose.jetpackcomposelearn.modifierPack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ModifierBasicExample() {
    Text(
        "Hello World!",
        fontSize = 28.sp,
        modifier = Modifier.background(Color.LightGray).padding(30.dp)
    )
}