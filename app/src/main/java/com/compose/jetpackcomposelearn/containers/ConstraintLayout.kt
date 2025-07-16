package com.compose.jetpackcomposelearn.containers

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun ConstraintLayoutExample() {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth().height(500.dp)
    ) {
        val (button, text) = createRefs()
        Button(onClick = {}, modifier = Modifier.constrainAs(button) {
            top.linkTo(parent.top, margin = 16.dp)
            start.linkTo(parent.start, margin = 16.dp)
        }) {
            Text("Click")
        }

        Text(text = "Text example",
            modifier = Modifier
                .constrainAs(text){
                    top.linkTo(button.bottom, margin = 16.dp)
                    start.linkTo(button.start)
                })
    }
}