package com.compose.jetpackcomposelearn.ui_components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.jetpackcomposelearn.borderModifier

@Composable
@Suppress("FunctionName")
fun SimpleButtonExample() {
    val context = LocalContext.current
    Column(modifier = Modifier.borderModifier, horizontalAlignment = Alignment.CenterHorizontally) {
        val customColors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4CAF50),
            contentColor = Color.White,
            disabledContainerColor = Color(0xFFBDBDBD),
            disabledContentColor = Color(0xFF757575)
        )

        Button(
            onClick = {
                Toast.makeText(context, "Simple button clicked", Toast.LENGTH_SHORT).show()
            },
            colors = customColors,
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                "Simple Button\nwith\nCustomStyle",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@Suppress("FunctionName")
fun ElevatedButtonExample() {
    val context = LocalContext.current
    Column(modifier = Modifier.borderModifier, horizontalAlignment = Alignment.CenterHorizontally) {
        val customColors = ButtonDefaults.elevatedButtonColors(
            containerColor = Color(0xFF6200EE),
            contentColor = Color.White,
            disabledContainerColor = Color(0xFFCCCCCC),
            disabledContentColor = Color(0xFF888888)
        )

        ElevatedButton(onClick = {
            Toast.makeText(context, "Elevated button clicked", Toast.LENGTH_SHORT).show()

        }, colors = customColors) {
            Text("Elevated Button")
        }
    }
}

@Composable
@Suppress("FunctionName")
fun FilledTonalButtonExample() {
    val context = LocalContext.current
    Column(modifier = Modifier.borderModifier, horizontalAlignment = Alignment.CenterHorizontally) {
        FilledTonalButton(onClick = {
            Toast.makeText(context, "Clicked FilledTonalButton", Toast.LENGTH_SHORT).show()
        }) {
            Text("FilledTonalButton")
        }
    }
}
