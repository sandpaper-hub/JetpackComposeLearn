package com.compose.jetpackcomposelearn.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun TransitionExample(modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }

    val transition = updateTransition(targetState = expanded, label = "boxTransition")

    val size by transition.animateDp(label = "size", transitionSpec = {
        tween(
            durationMillis = 500, delayMillis = 200, easing = FastOutSlowInEasing
        )
    }) { state ->
        if (state) 200.dp else 100.dp
    }

    val color by transition.animateColor(label = "color") { state ->
        if (state) Color.Green else Color.Gray
    }

    val cornerRadius by transition.animateDp(label = "cornerRadius") { state ->
        if (state) 16.dp else 0.dp
    }

    ConstraintLayout(modifier = modifier.then(Modifier.fillMaxSize())) {
        val box = createRef()

        Box(
            modifier = Modifier.constrainAs(box) {
                centerVerticallyTo(parent)
                centerHorizontallyTo(parent)
            }.size(size).background(color, shape = RoundedCornerShape(cornerRadius))
                .clickable { expanded = !expanded })
    }
}