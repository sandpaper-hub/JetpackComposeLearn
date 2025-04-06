package com.compose.jetpackcomposelearn.modifierPack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PaddingExample() {
    val innerPadding = PaddingValues(30.dp)
    Row(Modifier.fillMaxWidth().height(100.dp)) {
        Box(Modifier.size(30.dp).background(Color(0xFF22A45D)).padding(innerPadding))
        Box(Modifier.size(50.dp).padding(5.dp).background(Color(0xFF22A45D)).padding(10.dp))
        Box(Modifier.size(30.dp).offset(10.dp, 20.dp).background(Color(0xFF22A45D)))
    }
}