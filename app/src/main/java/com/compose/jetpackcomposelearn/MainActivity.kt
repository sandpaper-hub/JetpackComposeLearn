package com.compose.jetpackcomposelearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.jetpackcomposelearn.customLayoutModifier.CustomModifierLayoutExample
import com.compose.jetpackcomposelearn.customLayoutModifier.MyLayout
import com.compose.jetpackcomposelearn.ui.theme.JetpackComposeLearnTheme
import com.compose.jetpackcomposelearn.util.BorderComponent

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
        item { BorderComponent { CustomModifierLayoutExample() } }
        item {
            BorderComponent {
                Box(
                    Modifier.fillMaxWidth()
                        .height(400.dp)
                ) {
                    MyLayout(spacing = 20) {
                        Box(Modifier.size(50.dp).background(Color.DarkGray))
                        Box(Modifier.size(50.dp).background(Color.Red))
                        Box(Modifier.size(50.dp).background(Color.Green))
                        Box(Modifier.size(50.dp).background(Color.Blue))
                        Box(Modifier.size(50.dp).background(Color.Yellow))
                    }
                }
            }
        }
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