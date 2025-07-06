package com.compose.jetpackcomposelearn.ui_components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
@Suppress("FunctionName")
fun AlertDialogExample() {
    var showDialog by remember { mutableStateOf(false) }

    Button(onClick = { showDialog = true }) {
        Text("Show dialog")
    }

    if (showDialog){
        AlertDialog(
            onDismissRequest = { showDialog = false},
            confirmButton = {
                TextButton(onClick = {showDialog = false}) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = {showDialog = false}) {
                    Text("Cancel")
                }
            },
            title = {
                Text("Are you sure?")
            },
            text = {
                Text("This action can't cancel")
            }
        )
    }
}