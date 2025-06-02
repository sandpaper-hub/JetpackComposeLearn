package com.compose.jetpackcomposelearn.state

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val LocalFocusColor = compositionLocalOf { Color.Gray }

@Composable
@Suppress("FunctionName")
fun CompositionLocalFun() {
    val preferredColor = remember { Color(0xFF4CAF50) }
    CompositionLocalProvider(
        LocalFocusColor provides preferredColor
    ) {
        NestedFun()
    }
}

@Composable
@Suppress("FunctionName")
fun NestedFun() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .border(2.dp, MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        EditableField("Имя")
        EditableField("Фамилия")
    }
}

@Composable
@Suppress("FunctionName")
fun EditableField(label: String) {
    val focusColor = LocalFocusColor.current
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = focusColor,
            unfocusedIndicatorColor = focusColor.copy(alpha = 0.5f)
        ),
        label = { Text(label) }
    )
}