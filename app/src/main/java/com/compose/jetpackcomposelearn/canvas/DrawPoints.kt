package com.compose.jetpackcomposelearn.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun DrawPointsExample(modifier: Modifier) {
    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val canvas = createRef()

        Canvas(modifier = Modifier.size(200.dp).constrainAs(canvas) {
            centerHorizontallyTo(parent)
            centerVerticallyTo(parent)
        }) {
            drawPoints(
                points = listOf(
                    Offset(100f, 20f),
                    Offset(180f, 180f),
                    Offset(20f, 180f),
                    Offset(100f, 20f)
                ),
                pointMode = PointMode.Polygon,
                color = Color.Green,
                strokeWidth = 6f
            )
        }
    }
}