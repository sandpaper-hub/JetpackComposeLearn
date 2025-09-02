package com.compose.jetpackcomposelearn.viewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
@Suppress("FunctionName")
fun MainScreen(
    modifier: Modifier, viewModel: MainScreenViewModel = viewModel<MainScreenViewModel>()
) {
    val uiState by viewModel.screenUiState.collectAsState()
    val mainScreenState by viewModel.mainScreenState.collectAsState()
    var textFieldValue by remember { mutableStateOf("") }

    ConstraintLayout(modifier = modifier.then(Modifier.fillMaxSize())) {
        val (text, editText, button, progressIndicator) = createRefs()
        createVerticalChain(text, editText, button, chainStyle = ChainStyle.Packed)

        when (mainScreenState) {
            is MainScreenState.Success -> {
                Text(uiState.text, modifier = Modifier.constrainAs(text) {
                    centerHorizontallyTo(parent)
                    linkTo(top = parent.top, bottom = editText.top)
                })

                BasicTextField(
                    value = textFieldValue,
                    onValueChange = { textFieldValue = it },
                    modifier = Modifier
                        .size(350.dp, 56.dp)
                        .constrainAs(editText) {
                            centerHorizontallyTo(parent)
                            linkTo(top = text.bottom, bottom = button.top)
                        },
                    textStyle = TextStyle(fontSize = 16.sp, color = Color.White),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .background(
                                    color = Color.Transparent, shape = RoundedCornerShape(8.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = if (textFieldValue.isEmpty()) Color.Gray else Color.Blue,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(horizontal = 16.dp, vertical = 12.dp)
                        ) {
                            if (textFieldValue.isEmpty()) {
                                Text(
                                    text = "Input some text...",
                                    style = TextStyle(color = Color.Gray, fontSize = 16.sp)
                                )
                            }
                            innerTextField()
                        }
                    })
                Button(onClick = {
                    viewModel.changeText(textFieldValue)
                }, modifier = Modifier.constrainAs(button) {
                    centerHorizontallyTo(parent)
                    linkTo(top = editText.bottom, bottom = parent.bottom)
                }) {
                    Text("Change text")
                }
            }

            is MainScreenState.LoadingState -> {
                CircularProgressIndicator(modifier = Modifier.constrainAs(progressIndicator) {
                    centerTo(parent)
                })
            }
        }
    }
}