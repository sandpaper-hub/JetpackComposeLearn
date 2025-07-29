package com.compose.jetpackcomposelearn.coroutines

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
@Suppress("FunctionName")
fun DispatcherMainExample(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.then(Modifier.fillMaxSize())) {
        val scope = rememberCoroutineScope()
        val (simpleText, button) = createRefs()
        var textValue by remember { mutableStateOf("Default text") }
        createVerticalChain(simpleText, button, chainStyle = ChainStyle.Packed)

        Text(textValue, modifier = Modifier.constrainAs(simpleText) {
            centerHorizontallyTo(parent)
        })

        Button(onClick = {
            scope.launch {
                withContext(Dispatchers.Main) {
                    textValue = "Text has re-rendered"
                }
            }
        }, modifier = Modifier.constrainAs(button) {
            centerHorizontallyTo(parent)
        }.padding(8.dp)) {
            Text("Re-render")
        }
    }
}

@Composable
@Suppress("FunctionName")
fun DispatcherIOExample(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.then(Modifier.fillMaxSize())) {
        val scope = rememberCoroutineScope()
        val (text, startButton, progressIndicator) = createRefs()
        var progressValue by remember { mutableFloatStateOf(0f) }
        var textValue by remember { mutableStateOf("Push button to start") }

        createVerticalChain(progressIndicator, text, startButton, chainStyle = ChainStyle.Packed)

        LinearProgressIndicator(
            progress = { progressValue },
            modifier = Modifier.constrainAs(progressIndicator) {
                centerHorizontallyTo(parent)
            })

        Text(textValue, modifier = Modifier.constrainAs(text) {
            centerHorizontallyTo(parent)
        })

        Button(onClick = {
            scope.launch {
                withContext(Dispatchers.IO) {
                    progressValue = 0f
                    repeat(3) {
                        textValue = "Downloading"
                        repeat(3) {
                            if (textValue != "Downloading")
                                delay(1000)
                            textValue += "."
                            progressValue += 0.1f
                        }
                        delay(1000)
                    }
                    progressValue += 0.1f
                    textValue = "Finished"
                }
            }
        }, modifier = Modifier.constrainAs(startButton) {
            centerHorizontallyTo(parent)
        }) {
            Text("Start")
        }
    }
}