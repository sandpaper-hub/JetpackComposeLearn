package com.compose.jetpackcomposelearn.animation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun InfiniteTransitionExample(modifier: Modifier) {
    val infinite = rememberInfiniteTransition(label = "pulse")

    val alpha by infinite.animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha"
    )

    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val box = createRef()

        Box(
            modifier = Modifier.constrainAs(box) {
                centerVerticallyTo(parent)
                centerHorizontallyTo(parent)
            }
                .size(100.dp)
                .graphicsLayer(alpha = alpha)
                .background(Color.Magenta)
        )
    }
}