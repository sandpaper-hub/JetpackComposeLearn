package com.compose.jetpackcomposelearn.ui_components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
@Suppress("FunctionName")
fun SnackBarExample(snackBarHostState: SnackbarHostState) {
    SnackbarHost(
        hostState = snackBarHostState,
        snackbar = { snackBarData ->
            Snackbar(
                action = {
                    snackBarData.visuals.actionLabel.let { label ->
                        TextButton(onClick = { snackBarData.performAction() }) {
                            Text(text = label.toString(), color = Color.Yellow)
                        }
                    }
                },
                shape = RoundedCornerShape(12.dp),
                containerColor = Color(0xFF323232),
                contentColor = Color.White,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(snackBarData.visuals.message)
            }
        }
    )
}