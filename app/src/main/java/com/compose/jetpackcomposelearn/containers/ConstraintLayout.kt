package com.compose.jetpackcomposelearn.containers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun ConstraintLayoutExample(modifier: Modifier) {
    ConstraintLayout(
        modifier = modifier.then(Modifier.fillMaxSize())
    ) {
        val (button, text) = createRefs()
        Button(onClick = {}, modifier = Modifier.constrainAs(button) {
            top.linkTo(parent.top, margin = 16.dp)
            start.linkTo(parent.start, margin = 16.dp)
        }) {
            Text("Click")
        }

        Text(
            text = "Text example", modifier = Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
                start.linkTo(button.start)
            })
    }
}

@Composable
@Suppress("FunctionName")
fun ConstraintLayoutWithBiasExample(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.then(Modifier.fillMaxSize())) {
        val (box1, box2) = createRefs()

        Box(
            modifier = Modifier.size(100.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow)
                .constrainAs(box2) {
                    top.linkTo(box1.bottom, margin = 16.dp)
                    linkTo(parent.start, parent.end, bias = 0.75f)
                }
        )
    }
}