package com.compose.jetpackcomposelearn.coroutines

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.Dispatchers
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