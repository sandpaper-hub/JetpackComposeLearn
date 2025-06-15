package com.compose.jetpackcomposelearn.ui_components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.compose.jetpackcomposelearn.util.borderModifier

@Composable
@Suppress("functionName")
fun SimpleTextField() {
    Column(
        modifier = Modifier.borderModifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by remember { mutableStateOf("") }

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Email") },
            placeholder = { Text("Input your email...") },
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = null)
            },
            trailingIcon = {
                if (text.isNotEmpty()) {
                    IconButton(onClick = { text = "" }) {
                        Icon(Icons.Default.Close, contentDescription = "Clear")
                    }
                }
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Composable
@Suppress("FunctionName")
fun OutlinedTextFieldExample() {
    var email by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = email,
        onValueChange = {
            email = it
            isError = !android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches()
        },
        label = { Text("Email") },
        placeholder = { Text("example@domain.com") },
        singleLine = true,
        isError = isError,
        shape = RoundedCornerShape(24.dp),
        leadingIcon = {
            Icon(Icons.Default.Email, contentDescription = null)
        },
        trailingIcon = {
            if (email.isNotEmpty()) {
                IconButton(onClick = {
                    email = ""
                }) {
                    Icon(Icons.Default.Close, contentDescription = "Clear")
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = KeyboardActions.Default.onDone
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = if (isError) Color.Red else MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = if (isError) Color.Red.copy(alpha = 0.5f) else MaterialTheme.colorScheme.onSurface.copy(
                alpha = 0.5f
            )
        ),
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    )

    if (isError){
        Text(
            text = "Incorrect email",
            color = Color.Red,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(start = 16.dp, top = 4.dp)
        )
    }
}