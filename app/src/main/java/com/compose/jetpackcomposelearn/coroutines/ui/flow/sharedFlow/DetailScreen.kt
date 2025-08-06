package com.compose.jetpackcomposelearn.coroutines.ui.flow.sharedFlow

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun DetailScreen(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.then(Modifier.fillMaxSize())) {
        val mainText = createRef()

        Text("This is DetailScreen", modifier = Modifier.constrainAs(mainText) {
            centerHorizontallyTo(parent)
            centerVerticallyTo(parent)
        })
    }
}