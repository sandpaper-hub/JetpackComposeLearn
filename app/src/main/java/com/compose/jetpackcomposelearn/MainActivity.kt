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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.jetpackcomposelearn.containers.BoxExample
import com.compose.jetpackcomposelearn.containers.CardExample
import com.compose.jetpackcomposelearn.containers.ColumnExample
import com.compose.jetpackcomposelearn.containers.LazyColumnExample
import com.compose.jetpackcomposelearn.containers.RowExample
import com.compose.jetpackcomposelearn.containers.SurfaceExample
import com.compose.jetpackcomposelearn.ui.theme.JetpackComposeLearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeLearnTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContainerExample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ContainerExample(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        item { BoxExample() }
        item { ColumnExample() }
        item { RowExample() }
        item { SurfaceExample() }
        item { CardExample() }
        item { LazyColumnExample() }
    }
}

@Preview(showBackground = true)
@Composable
fun ContainerExamplePreview() {
    JetpackComposeLearnTheme {
        ContainerExample()
    }
}