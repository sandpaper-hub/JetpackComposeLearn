package com.compose.jetpackcomposelearn.animation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
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
fun AnimateDpExample(modifier: Modifier) {
    var big by remember { mutableStateOf(false) }
    var size = animateDpAsState(
        targetValue = if (big) 200.dp else 100.dp,
        animationSpec = spring(dampingRatio = 0.5f)
    )

    ConstraintLayout(modifier = modifier.then(Modifier.fillMaxSize())) {
        val box = createRef()

        Box(
            modifier = Modifier
                .constrainAs(box) {
                    centerVerticallyTo(parent)
                    centerHorizontallyTo(parent)
                }
                .size(size.value)
                .background(Color.Magenta)
                .clickable { big = !big })
    }
}