package com.compose.jetpackcomposelearn.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun AnimatedVisibilityExample(modifier: Modifier) {
    var visibleFade by rememberSaveable { mutableStateOf(true) }
    var visibleSlide by rememberSaveable { mutableStateOf(true) }
    var visibleExpand by rememberSaveable { mutableStateOf(true) }

    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val (column1, column2, column3) = createRefs()
        createVerticalChain(column1, column2, column3, chainStyle = ChainStyle.Packed)

        Column(
            modifier = Modifier.constrainAs(column1) {
                linkTo(top = parent.top, bottom = column2.bottom)
                centerHorizontallyTo(parent)
            },
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("1. fadeIn / fadeOut", style = MaterialTheme.typography.titleMedium)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { visibleFade = !visibleFade }) {
                    Text(if (visibleFade) "Hide" else "Show")
                }
            }
            AnimatedVisibility(
                visible = visibleFade, enter = fadeIn(
                    animationSpec = tween(
                        durationMillis = 450, easing = LinearOutSlowInEasing
                    )
                ), exit = fadeOut(
                    animationSpec = tween(
                        durationMillis = 300, easing = FastOutLinearInEasing
                    )
                ), label = "fade-only"
            ) {
                DemoCard("fade", Color(0xFFFF80AB))
            }
        }

        Column(
            modifier = Modifier.constrainAs(column2) {
                linkTo(top = column1.bottom, bottom = column3.top)
                centerHorizontallyTo(parent)
            }, verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("2. slide + fade", style = MaterialTheme.typography.titleMedium)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { visibleSlide = !visibleSlide }) {
                    Text(if (visibleSlide) "Hide" else "Show")
                }
            }
            AnimatedVisibility(
                visible = visibleSlide,
                enter = slideInVertically(
                    initialOffsetY = { fullHeight -> -fullHeight / 2 },
                    animationSpec = tween(500, delayMillis = 100, easing = FastOutSlowInEasing)
                ) + fadeIn(animationSpec = tween(500)),
                exit = slideOutVertically(
                    targetOffsetY = { fullHeight -> fullHeight / 2 },
                    animationSpec = tween(400, easing = FastOutLinearInEasing)
                ) + fadeOut(animationSpec = tween(300)),
                label = "slide-fade"
            ) {
                DemoCard("slide-fade", Color(0xFF82B1FF))
            }
        }

        Column(
            modifier = Modifier.constrainAs(column3) {
                linkTo(top = column2.bottom, bottom = parent.bottom)
                centerHorizontallyTo(parent)
            },
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("3. expandUn + shrinkOut", style = MaterialTheme.typography.titleMedium)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { visibleExpand = !visibleExpand }) {
                    Text(if (visibleExpand) "Hide" else "Show")
                }
            }
            AnimatedVisibility(visible = visibleExpand,
                enter = expandIn(
                    expandFrom = Alignment.TopStart,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                ) + fadeIn(animationSpec = tween(200)),
                exit = shrinkOut(
                    shrinkTowards = Alignment.Center,
                    animationSpec = tween(350, easing = LinearOutSlowInEasing)
                ) + fadeOut(animationSpec = tween(200)),
                label = "expand-shrink"
            ) {
                DemoCard("expand + shrink", Color(0xFFB9F6CA))
            }
        }
    }
}


@Composable
@Suppress("FunctionName")
private fun DemoCard(text: String, color: Color) {
    Box(
        modifier = Modifier.fillMaxWidth().height(96.dp)
            .background(color, RoundedCornerShape(16.dp)).padding(16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(text = text, style = MaterialTheme.typography.titleLarge, color = Color.Black)
    }
}