package com.compose.jetpackcomposelearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.jetpackcomposelearn.coroutines.DispatcherDefaultExample
import com.compose.jetpackcomposelearn.ui.theme.JetpackComposeLearnTheme

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
    DispatcherDefaultExample(modifier)
}

@Preview(name = "Galaxy S23 Plus", widthDp = 393, heightDp = 851)
@Composable
@Suppress("FunctionName")
fun MainExamplePreview() {
    JetpackComposeLearnTheme {
        MainExample()
    }
}