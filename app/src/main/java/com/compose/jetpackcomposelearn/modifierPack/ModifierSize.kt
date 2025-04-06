package com.compose.jetpackcomposelearn.modifierPack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SizeExample() {
    Row(Modifier.fillMaxWidth().height(30.dp)) {
        Box(Modifier.width(30.dp).height(30.dp).background(Color(0xFFF7DE00)))
        Box(Modifier.size(30.dp).background(Color(0xFF186DDD)))
        Box(Modifier.width(30.dp).fillMaxHeight().background(Color(0xFF22A45D)))
    }
}