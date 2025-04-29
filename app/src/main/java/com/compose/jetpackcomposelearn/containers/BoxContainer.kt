package com.compose.jetpackcomposelearn.containers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BoxExample() {
    Box(modifier = Modifier.size(200.dp).background(MaterialTheme.colorScheme.primaryContainer)) {
        Text("Box container", modifier = Modifier.align(Alignment.TopStart))
        Icon(
            Icons.Default.Favorite,
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )
        Text("Наложенный текст", modifier = Modifier.align(Alignment.BottomEnd))
    }

}