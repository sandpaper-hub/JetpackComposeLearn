package com.compose.jetpackcomposelearn.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
@Suppress("FunctionName")
fun DrawArcExample(modifier: Modifier) {
    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val (arcCanvas, arcStroke, circularProgress) = createRefs()
        createVerticalChain(arcCanvas, arcStroke, circularProgress, chainStyle = ChainStyle.SpreadInside)

        ArcSector(Modifier.constrainAs(arcCanvas) {
            centerHorizontallyTo(parent)
            linkTo(top = parent.top, bottom = arcStroke.top)
        })
        ArcStroke(Modifier.constrainAs(arcStroke) {
            centerHorizontallyTo(parent)
            linkTo(top = arcCanvas.bottom, bottom = circularProgress.top)
        })
        CircularProgress(modifier = Modifier.constrainAs(circularProgress) {
            centerHorizontallyTo(parent)
            linkTo(top = arcStroke.bottom, bottom = parent.bottom)
        })
    }
}

@Composable
@Suppress("FunctionName")
fun ArcSector(modifier: Modifier) {
    Canvas(modifier = modifier.then(Modifier.size(200.dp))) {
        drawArc(
            color = Color.Red,
            startAngle = 0f,
            sweepAngle = 90f,
            useCenter = true
        )
    }
}

@Composable
@Suppress("FunctionName")
fun ArcStroke(modifier: Modifier) {
    Canvas(modifier = modifier.then(Modifier.size(200.dp))) {
        drawArc(
            color = Color.Blue,
            startAngle = -90f,
            sweepAngle = 180f,
            useCenter = false,
            style = Stroke(width = 12f)
        )
    }
}

@Composable
@Suppress("FunctionName")
fun CircularProgress(modifier: Modifier) {
    Canvas(modifier.then(Modifier.size(200.dp))) {
        drawArc(
            color = Color.Green,
            startAngle = -90f,
            sweepAngle = 360f * 0.65f,
            useCenter = false,
            style = Stroke(width = 20f, cap = StrokeCap.Round)
        )
    }
}