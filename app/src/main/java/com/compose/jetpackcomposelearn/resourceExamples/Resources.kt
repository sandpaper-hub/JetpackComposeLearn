package com.compose.jetpackcomposelearn.resourceExamples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.compose.jetpackcomposelearn.R

val Red = Color(0xFFE57373)

@Composable
@Suppress("FunctionName")
fun ColorsExample() {
    Box(modifier = Modifier
        .size(48.dp)
        .background(Red))
}

@Composable
@Suppress("FunctionName")
fun StringResourceExample() {
    val testStringResource = stringResource(id = R.string.someStringValue)
    Text(testStringResource)
}