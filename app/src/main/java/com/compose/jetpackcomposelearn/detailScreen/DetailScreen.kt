package com.compose.jetpackcomposelearn.detailScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
@Suppress("FunctionName")
fun DetailScreen(modifier: Modifier) {
    Box(modifier = modifier
        .fillMaxSize()){
        Text("Detail Screen")
    }
}