package com.compose.jetpackcomposelearn.modifierPack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ClipExample() {
    Row {
        Text(
            "This is Clip",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .background(Color.LightGray)
                .padding(15.dp)
        )
    }
}