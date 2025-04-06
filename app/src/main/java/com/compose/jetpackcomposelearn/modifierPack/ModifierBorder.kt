package com.compose.jetpackcomposelearn.modifierPack

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BorderExample() {
    Row(Modifier.fillMaxWidth().height(100.dp)) {
        Text(
            "Some text",
            fontSize = 18.sp,
            modifier = Modifier.padding(5.dp).border(width = 2.dp, color = Color(0xFF2F3233))
        )
        Text(
            "Padding",
            fontSize = 18.sp,
            modifier = Modifier.padding(10.dp).border(width = 2.dp, color = Color(0xFF43B726))
                .padding(5.dp)
        )
        Text(
            "Shape",
            fontSize = 18.sp,
            modifier = Modifier.padding(10.dp).border(width = 2.dp, color = Color(0xFFE23D24), shape = RoundedCornerShape(20.dp))
                .padding(5.dp)
        )
    }
}