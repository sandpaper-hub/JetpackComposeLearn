package com.compose.jetpackcomposelearn.ui_components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.compose.jetpackcomposelearn.R

@Composable
@Suppress("FunctionName")
fun ImageExample() {
    Image(painter = painterResource(R.drawable.pizza), contentDescription = null)
}