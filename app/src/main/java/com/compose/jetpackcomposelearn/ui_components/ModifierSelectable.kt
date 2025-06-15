package com.compose.jetpackcomposelearn.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
@Suppress("FunctionName")
fun SelectableExample() {
    var selected by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .selectable(
                selected = selected,
                onClick = { selected = !selected },
                role = Role.Checkbox
            )
            .background(if (selected) Color.LightGray else Color.Transparent)
            .padding(16.dp)
    ) {
        Text("Push me")
    }
}

@Composable
@Suppress("FunctionName")
fun RadioGroupSample() {
    val options = listOf("Red", "Green", "Blue")
    var selectedOptions by remember { mutableStateOf(options[0]) }

    Column(
        modifier = Modifier
            .selectableGroup()
            .padding(16.dp)
    )
    {
        options.forEach { color ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (color == selectedOptions),
                        onClick = { selectedOptions = color },
                        role = Role.RadioButton
                    )
                    .padding(8.dp)
            ) {
                RadioButton(
                    selected = (color == selectedOptions),
                    onClick = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = color)
            }
        }
    }
}