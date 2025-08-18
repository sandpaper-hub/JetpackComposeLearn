package com.compose.jetpackcomposelearn.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun DrawCircleExample(modifier: Modifier) {
    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val canvas = createRef()

        Canvas(
            modifier = Modifier
                .constrainAs(canvas) {
                    centerVerticallyTo(parent)
                    centerHorizontallyTo(parent)
                }
                .size(200.dp)) {
            drawCircle(
                color = Color.Red,
                radius = 80f,
                center = center
            )
        }
    }
}