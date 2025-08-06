package com.compose.jetpackcomposelearn.coroutines.ui.flow.simpleFlow

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.compose.jetpackcomposelearn.coroutines.viewModel.flow.simpleFlow.LoadingViewModel

@Composable
@Suppress("FunctionName")
fun SimpleFlowExample(modifier: Modifier, viewModel: LoadingViewModel) {
    ConstraintLayout(modifier = modifier.then(Modifier.fillMaxSize())) {
        val (text, progress, button) = createRefs()
        val textValue by viewModel.status.collectAsState()
        val progressValue by viewModel.progress.collectAsState()

        createVerticalChain(progress, text, button, chainStyle = ChainStyle.Packed)

        LinearProgressIndicator(
            progress = { progressValue },
            modifier = Modifier.constrainAs(progress) {
                centerHorizontallyTo(parent)
            })

        Text(
            textValue, modifier = Modifier.constrainAs(text) {
                centerHorizontallyTo(parent)
            })

        Button(onClick = { viewModel.startLoading() }, modifier = Modifier.constrainAs(button) {
            centerHorizontallyTo(parent)
        }) {
            Text("Start")
        }
    }
}