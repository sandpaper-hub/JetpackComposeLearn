package com.compose.jetpackcomposelearn.ui_components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
@Suppress("FunctionName")
fun FloatingActionButtonExample(onClickAction: () -> Unit) {
    FloatingActionButton(
        onClick = onClickAction,
        content = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add"
            )
        }
    )
}