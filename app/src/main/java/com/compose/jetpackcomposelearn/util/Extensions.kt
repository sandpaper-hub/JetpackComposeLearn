package com.compose.jetpackcomposelearn.util

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
@Suppress("FunctionName")
fun BorderComponent(component: @Composable () -> Unit) {
    Column(
        modifier = Modifier.borderModifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        component()
    }
}

val Modifier.borderModifier: Modifier
    @Composable
    get() = this
        .fillMaxWidth()
        .padding(12.dp)
        .border(2.dp, MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(8.dp))
        .padding(12.dp)