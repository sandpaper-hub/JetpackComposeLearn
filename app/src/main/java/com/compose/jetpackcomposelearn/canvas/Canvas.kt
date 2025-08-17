package com.compose.jetpackcomposelearn.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
@Suppress("FunctionName")
fun MultipleDrawExample(modifier: Modifier) {
    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val canvas = createRef()

        Canvas(modifier = Modifier.size(250.dp).constrainAs(canvas) {
            centerVerticallyTo(parent)
            centerHorizontallyTo(parent)
        }) {
            drawRect(Color.Red, size = size / 2f, topLeft = Offset(size.width / 4, size.height / 4))

            drawCircle(Color.Blue, radius = 60f, center = center)

            drawLine(
                color = Color.Green,
                start = Offset(0f, 0f),
                end = Offset(size.width, size.height),
                strokeWidth = 5f
            )
        }
    }
}