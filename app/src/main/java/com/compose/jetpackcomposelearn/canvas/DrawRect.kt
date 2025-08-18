package com.compose.jetpackcomposelearn.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun DrawRectExample(modifier: Modifier) {
    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val canvas = createRef()

        Canvas(
            modifier = Modifier
            .constrainAs(canvas) {
                centerVerticallyTo(parent)
                centerHorizontallyTo(parent)
            }
            .size(200.dp)) {
            drawRect(
                color = Color.Blue,
                topLeft = Offset(40f, 40f),
                size = Size(120f, 80f),
                style = Stroke(width = 8f)
            )
        }
    }
}