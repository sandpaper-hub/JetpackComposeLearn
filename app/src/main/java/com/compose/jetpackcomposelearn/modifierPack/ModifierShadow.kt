package com.compose.jetpackcomposelearn.modifierPack

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShadowExample() {
    Row {
        Text(
            "This is shadow text",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(20.dp)
                .shadow(4.dp, shape = CircleShape)
                .padding(20.dp)
        )
    }
}