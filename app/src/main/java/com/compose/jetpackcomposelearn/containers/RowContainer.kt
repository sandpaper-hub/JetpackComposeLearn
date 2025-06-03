package com.compose.jetpackcomposelearn.containers

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RowExample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(
                border = BorderStroke(2.dp, MaterialTheme.colorScheme.primaryContainer),
                RoundedCornerShape(16.dp)
            ).padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val descriptionContent = remember { mutableStateOf("Like") }
        val count = remember { mutableIntStateOf(0) }
        Icon(Icons.Default.Favorite, contentDescription = null)
        Text(descriptionContent.value)
        Button(onClick = {
            count.intValue += 1
            descriptionContent.value = "Liked ${count.intValue}"
        }) {
            Text("Click me")
        }
        Text("Row container")
    }
}