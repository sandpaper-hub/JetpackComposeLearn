package com.compose.jetpackcomposelearn.util

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
@Suppress("FunctionName")
fun BorderComponent(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.borderModifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}