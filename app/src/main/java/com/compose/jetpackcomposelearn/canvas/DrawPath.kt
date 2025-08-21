package com.compose.jetpackcomposelearn.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun DrawPathExample(modifier: Modifier) {
    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val canvas = createRef()

        Canvas(modifier = Modifier.size(200.dp).constrainAs(canvas) {
            centerHorizontallyTo(parent)
            centerVerticallyTo(parent)
        }) {
            val width = size.width
            val height = size.height

            val path = Path().apply {
                moveTo(width / 2, height * 0.75f)
                cubicTo(width * 1.2f, height * 0.35f, width * 0.8f, 0f, width / 2, height * 0.25f)
                cubicTo(width * 0.2f, 0f, -width * 0.2f, height * 0.35f, width / 2, height * 0.75f)
                close()
            }

            drawPath(path = path, brush = Brush.linearGradient(
                listOf(Color.Red, Color.Magenta)
            ))
        }
    }
}