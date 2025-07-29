package com.compose.jetpackcomposelearn.coroutines

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
@Suppress("FunctionName")
fun JobExample(modifier: Modifier) {
    val scope = rememberCoroutineScope()
    var job by remember { mutableStateOf<Job?>(null) }
    var textValue by remember { mutableStateOf("Waiting...") }

    ConstraintLayout(modifier = modifier.then(Modifier.fillMaxSize())) {
        val (text, buttonStart, buttonCancel) = createRefs()

        createVerticalChain(text, buttonStart, buttonCancel, chainStyle = ChainStyle.Packed)

        Text(textValue, modifier = Modifier.constrainAs(text) {
            centerHorizontallyTo(parent)
        })

        Button(onClick = {
            job = scope.launch {
                textValue = "Process's started"
                delay(5000)
                textValue = "Ready!"
            }
        }, modifier = Modifier.constrainAs(buttonStart) {
            centerHorizontallyTo(parent)
        }) {
            Text("Start")
        }

        Button(onClick = {
            job = scope.launch {
                job?.cancel()
                textValue = "Canceled"
            }
        }, modifier = Modifier.constrainAs(buttonCancel) {
            centerHorizontallyTo(parent)
        }) {
            Text("Cancel")
        }
    }
}