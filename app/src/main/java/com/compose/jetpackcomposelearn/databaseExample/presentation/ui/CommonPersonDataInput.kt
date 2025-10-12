package com.compose.jetpackcomposelearn.databaseExample.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
@Suppress("FunctionName")
fun CommonPersonDataInput(
    modifier: Modifier,
    completeAction: (String, String, Boolean) -> Unit,
    buttonVisibility: Boolean
) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf(false) }

    Column(
        modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Input name", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            singleLine = true,
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Text("Input age", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = age,
            onValueChange = { value ->
                age = value.filter { it.isDigit() }
            },
            label = { Text("Age") },
            singleLine = true,
            shape = RoundedCornerShape(24.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Column {
            Text("Gender")
            Row(modifier = Modifier.selectableGroup()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.selectable(
                        selected = !gender,
                        onClick = { gender = false })
                ) {
                    RadioButton(selected = !gender, null)
                    Text("Male")
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.selectable(
                        selected = gender,
                        onClick = { gender = true })
                ) {
                    RadioButton(selected = gender, null)
                    Text("Female")
                }
            }
        }

        if (buttonVisibility) {
            Button(
                { completeAction(name, age, gender) }, modifier = Modifier.align(Alignment.End)
            ) {
                Text("Add")
            }
        }
    }

}