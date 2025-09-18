package com.compose.jetpackcomposelearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.jetpackcomposelearn.databaseExample.presentation.ui.PersonsScreen
import com.compose.jetpackcomposelearn.ui.theme.JetpackComposeLearnTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeLearnTheme {
                PersonsScreen()
            }
        }
    }
}

@Composable
@Suppress("FunctionName")
fun MainExample(modifier: Modifier = Modifier) {

}

@Preview(name = "Galaxy S23 Plus", widthDp = 393, heightDp = 851)
@Composable
@Suppress("FunctionName")
fun MainExamplePreview() {
    JetpackComposeLearnTheme {
        MainExample()
    }
}