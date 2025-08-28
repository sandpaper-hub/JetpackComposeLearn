package com.compose.jetpackcomposelearn.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun TransformationsExample(modifier: Modifier) {
    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val (rotateCanvas, scaleCanvas, translateCanvas) = createRefs()
        createVerticalChain(
            rotateCanvas,
            scaleCanvas,
            translateCanvas,
            chainStyle = ChainStyle.Packed
        )
        Canvas(modifier = Modifier.size(200.dp).constrainAs(rotateCanvas) {
            centerHorizontallyTo(parent)
            top.linkTo(parent.top)
            bottom.linkTo(scaleCanvas.top)
        }) {
            rotate(degrees = 45f) {
                drawRect(Color.Red, size = size / 2f)
            }
        }

        Canvas(modifier = Modifier.size(200.dp).constrainAs(scaleCanvas) {
            centerHorizontallyTo(parent)
            top.linkTo(rotateCanvas.bottom)
            bottom.linkTo(translateCanvas.top)
        }) {
            scale(1.5f) {
                drawCircle(Color.Blue, radius = 80f, center = center)
            }
        }

        Canvas(modifier = Modifier.size(200.dp).constrainAs(translateCanvas) {
            centerHorizontallyTo(parent)
            top.linkTo(scaleCanvas.bottom)
            bottom.linkTo(parent.bottom)
        }) {
            translate(left = 50f, top = 80f) {
                drawRect(Color.Green, size = Size(60f, 60f))
            }
        }
    }
}