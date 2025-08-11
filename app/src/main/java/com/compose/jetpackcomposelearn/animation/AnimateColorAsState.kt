package com.compose.jetpackcomposelearn.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun AnimateColorAsStateExample(modifier: Modifier) {
    var isRed by remember { mutableStateOf(true) }
    val color by animateColorAsState(
        targetValue = if (isRed) Color.Red else Color.Blue,
        animationSpec = tween(durationMillis = 1000),
        label = "boxColor"
    )

    ConstraintLayout(modifier = modifier.then(Modifier.fillMaxSize())) {
        val box = createRef()

        Box(
            modifier = Modifier
                .constrainAs(box) {
                    centerVerticallyTo(parent)
                    centerHorizontallyTo(parent)
                }
                .size(150.dp)
                .background(color)
                .clickable { isRed = !isRed })
    }
}