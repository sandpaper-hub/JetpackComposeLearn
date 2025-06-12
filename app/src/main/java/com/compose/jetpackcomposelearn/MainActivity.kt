package com.compose.jetpackcomposelearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.jetpackcomposelearn.ui.theme.JetpackComposeLearnTheme
import com.compose.jetpackcomposelearn.ui_components.AnnotatedTextExample
import com.compose.jetpackcomposelearn.ui_components.ClickableTextExample
import com.compose.jetpackcomposelearn.ui_components.ElevatedButtonExample
import com.compose.jetpackcomposelearn.ui_components.FilledTonalButtonExample
import com.compose.jetpackcomposelearn.ui_components.OutlinedButtonExample
import com.compose.jetpackcomposelearn.ui_components.OutlinedTextFieldExample
import com.compose.jetpackcomposelearn.ui_components.SimpleButtonExample
import com.compose.jetpackcomposelearn.ui_components.SimpleText
import com.compose.jetpackcomposelearn.ui_components.SimpleTextField
import com.compose.jetpackcomposelearn.ui_components.TextButtonExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeLearnTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainExample(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
@Suppress("FunctionName")
fun MainExample(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        item { SimpleText() }
        item { AnnotatedTextExample() }
        item { ClickableTextExample() }
        item { SimpleButtonExample() }
        item { ElevatedButtonExample() }
        item { FilledTonalButtonExample() }
        item { OutlinedButtonExample() }
        item { TextButtonExample() }
        item { SimpleTextField() }
        item { OutlinedTextFieldExample() }
    }
}

@Preview(name = "Galaxy S23 Plus", widthDp = 393, heightDp = 851)
@Composable
@Suppress("FunctionName")
fun MainExamplePreview() {
    JetpackComposeLearnTheme {
        MainExample()
    }
}