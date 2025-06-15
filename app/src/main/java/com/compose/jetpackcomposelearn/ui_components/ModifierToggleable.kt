package com.compose.jetpackcomposelearn.ui_components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.compose.jetpackcomposelearn.borderModifier

@Composable
@Suppress("FunctionName")
fun ToggleableExample() {
    Column(
        modifier = Modifier.borderModifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var isOptionSelected by remember { mutableStateOf(false) }

        CustomCheckBox(
            checked = isOptionSelected,
            onCheckedChanged = { isOptionSelected = it }
        )
    }
}

@Composable
@Suppress("FunctionName")
fun CustomCheckBox(
    checked: Boolean,
    onCheckedChanged: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .toggleable(
                value = checked,
                onValueChange = onCheckedChanged,
                role = Role.Checkbox
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (checked) Icons.Default.Check else Icons.Default.CheckCircle,
            contentDescription = if (checked) "On" else "Off"
        )
        Spacer(Modifier.width(8.dp))
        Text("Choose option")
    }
}