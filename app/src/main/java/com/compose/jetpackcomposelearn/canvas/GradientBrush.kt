package com.compose.jetpackcomposelearn.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun GradientBrushExample(modifier: Modifier) {
    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val canvas = createRef()

        Canvas(
            modifier = Modifier
                .size(200.dp)
                .constrainAs(canvas) {
                    centerHorizontallyTo(parent)
                    centerVerticallyTo(parent)
                }) {
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(Color.Yellow, Color.Red),
                    center = center,
                    radius = size.minDimension / 2
                )
            )
        }
    }
}