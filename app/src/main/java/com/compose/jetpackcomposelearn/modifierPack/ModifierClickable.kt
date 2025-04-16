package com.compose.jetpackcomposelearn.modifierPack

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ClickableExample() {
    val count = remember { mutableIntStateOf(0) }

    Row {
        Text("Clicks: ${count.intValue}",
            fontSize = 18.sp, modifier = Modifier.clickable(onClick = {count.intValue += 1}))
    }
}