package com.compose.jetpackcomposelearn.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun AnimateEnterExitExample(modifier: Modifier) {
    var visible by remember { mutableStateOf(false) }

    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val (button, animatedVisibility) = createRefs()

        Button(onClick = { visible = !visible }, modifier = Modifier.constrainAs(button) {
            centerHorizontallyTo(parent)
            centerVerticallyTo(parent)
        }) {
            Text("Toggle")
        }

        AnimatedVisibility(visible = visible, modifier = Modifier.constrainAs(animatedVisibility) {
            centerHorizontallyTo(parent)
            top.linkTo(button.bottom)
        },
            enter = EnterTransition.None,
            exit = ExitTransition.None) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "Fade + Slide",
                    modifier = Modifier.animateEnterExit(
                        enter = fadeIn(animationSpec = tween(900)) + // 2 секунды
                                slideInHorizontally(
                                    initialOffsetX = { fullWidth -> -fullWidth },
                                    animationSpec = tween(900)
                                ),
                        exit = fadeOut(animationSpec = tween(900)) +
                                slideOutHorizontally(
                                    targetOffsetX = { fullWidth -> fullWidth },
                                    animationSpec = tween(900)
                                )
                    )
                )
                Text(
                    "Scale",
                    modifier = Modifier.animateEnterExit(
                        enter = scaleIn(
                            animationSpec = tween(2000, easing = LinearOutSlowInEasing)
                        ),
                        exit = scaleOut(animationSpec = tween(2000))
                    )
                )

            }
        }
    }
}