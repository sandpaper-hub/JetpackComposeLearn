package com.compose.jetpackcomposelearn.ui_components

import android.content.Context
import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

fun onRefresh(context: Context) {
    Toast.makeText(context, "Refreshed", Toast.LENGTH_SHORT).show()
}

@Composable
@Suppress("FunctionName")
fun IconButtonExample(onRefresh: () -> Unit) {
    IconButton(onClick = onRefresh) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "Refresh data"

        )
    }
}