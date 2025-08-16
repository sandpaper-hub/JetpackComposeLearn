package com.compose.jetpackcomposelearn.animation

import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun AnimateFloatAsStateExample(modifier: Modifier) {
    var visible by remember { mutableStateOf(true) }
    val alpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(1000),
        label = "alpha"
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
                .graphicsLayer(alpha = alpha)
                .background(Color.Magenta)
                .clickable { visible = !visible }
        )
    }
}