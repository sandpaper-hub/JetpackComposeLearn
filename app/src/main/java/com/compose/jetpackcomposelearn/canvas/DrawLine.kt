package com.compose.jetpackcomposelearn.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun DrawLineExample(modifier: Modifier) {
    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val canvas = createRef()

        Canvas(
            modifier = Modifier
                .constrainAs(canvas) {
                    centerVerticallyTo(parent)
                    centerHorizontallyTo(parent)
                }
                .size(200.dp)) {
            val y = size.height / 2

            drawLine(
                Color.Blue,
                start = Offset(20f, y - 40f),
                end = Offset(size.width - 20f, y - 40f),
                strokeWidth = 20f,
                cap = StrokeCap.Butt
            )

            drawLine(
                Color.Green,
                start = Offset(20f, y),
                end = Offset(size.width - 20f, y),
                strokeWidth = 20f,
                cap = StrokeCap.Round
            )

            drawLine(
                Color.Red,
                start = Offset(20f, y + 40f),
                end = Offset(size.width - 20f, y + 40f),
                strokeWidth = 20f,
                cap = StrokeCap.Square
            )
        }
    }
}