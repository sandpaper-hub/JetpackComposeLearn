package com.compose.jetpackcomposelearn.animation

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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
fun CrossFadeExample(modifier: Modifier) {
    var toggled by remember { mutableStateOf(false) }

    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val (button, crossFade) = createRefs()

        Button(onClick = { toggled = !toggled }, Modifier.constrainAs(button) {
            centerHorizontallyTo(parent)
            linkTo(top = parent.top, bottom = parent.bottom)
        }) {
            Text("Toggle")
        }

        Crossfade(
            targetState = toggled,
            animationSpec = tween(1000),
            modifier = Modifier.constrainAs(crossFade) {
                centerHorizontallyTo(parent)
                top.linkTo(button.bottom)
            }) { state ->
            Box(
                modifier = Modifier.size(150.dp)
                    .background(if (state) Color.Green else Color.Magenta)
            )
        }
    }
}


