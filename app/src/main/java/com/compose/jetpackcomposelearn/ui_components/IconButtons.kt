package com.compose.jetpackcomposelearn.ui_components

import android.content.Context
import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

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

@Composable
@Suppress("FunctionName")
fun IconToggleButtonExample() {
    var isFavorite by remember { mutableStateOf(false) }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = { newValue -> isFavorite = newValue }
    ) {
        Icon(
            imageVector = if (isFavorite) Icons.Default.Favorite else
                Icons.Default.FavoriteBorder,
            contentDescription = if (isFavorite) "Favorite" else "Not favorite"
        )
    }
}