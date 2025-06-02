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
import com.compose.jetpackcomposelearn.state.RememberSaveableFun
import com.compose.jetpackcomposelearn.state.SimpleStateExample
import com.compose.jetpackcomposelearn.state.SimpleUdfExample
import com.compose.jetpackcomposelearn.ui.theme.JetpackComposeLearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeLearnTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainFunction(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
@Suppress("FunctionName")
fun MainFunction(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        item { SimpleStateExample() }
        item { RememberSaveableFun() }
        item { SimpleUdfExample() }
    }
}

@Preview(showBackground = true)
@Composable
@Suppress("FunctionName")
fun GreetingPreview() {
    JetpackComposeLearnTheme {
        MainFunction()
    }
}