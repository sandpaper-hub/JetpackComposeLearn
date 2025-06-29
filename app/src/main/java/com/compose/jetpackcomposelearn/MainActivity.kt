package com.compose.jetpackcomposelearn

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.compose.jetpackcomposelearn.ui.theme.JetpackComposeLearnTheme
import com.compose.jetpackcomposelearn.ui_components.AnnotatedTextExample
import com.compose.jetpackcomposelearn.ui_components.BottomAppBarExample
import com.compose.jetpackcomposelearn.ui_components.CheckBoxExample
import com.compose.jetpackcomposelearn.ui_components.ClickableTextExample
import com.compose.jetpackcomposelearn.ui_components.ElevatedButtonExample
import com.compose.jetpackcomposelearn.ui_components.FilledTonalButtonExample
import com.compose.jetpackcomposelearn.ui_components.FloatingActionButtonExample
import com.compose.jetpackcomposelearn.ui_components.IconButtonExample
import com.compose.jetpackcomposelearn.ui_components.IconToggleButtonExample
import com.compose.jetpackcomposelearn.ui_components.OutlinedButtonExample
import com.compose.jetpackcomposelearn.ui_components.OutlinedTextFieldExample
import com.compose.jetpackcomposelearn.ui_components.RadioButtonExample
import com.compose.jetpackcomposelearn.ui_components.RadioGroupSample
import com.compose.jetpackcomposelearn.ui_components.SelectableExample
import com.compose.jetpackcomposelearn.ui_components.SimpleButtonExample
import com.compose.jetpackcomposelearn.ui_components.SimpleText
import com.compose.jetpackcomposelearn.ui_components.SimpleTextField
import com.compose.jetpackcomposelearn.ui_components.TextButtonExample
import com.compose.jetpackcomposelearn.ui_components.ToggleableExample
import com.compose.jetpackcomposelearn.ui_components.TopAppBarExample
import com.compose.jetpackcomposelearn.ui_components.onRefresh
import com.compose.jetpackcomposelearn.util.BorderComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeLearnTheme {
                val context = LocalContext.current
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        FloatingActionButtonExample {
                            Toast.makeText(
                                context, "FAB pushed",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    topBar = {
                        TopAppBarExample(
                            title = "ToDo",
                            onNavigationClick = {
                                Toast.makeText(
                                    context,
                                    "Navigation up",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }) {
                            IconButton(onClick = {
                                Toast.makeText(
                                    context,
                                    "Search",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }) { Icon(Icons.Default.Search, "Search") }
                            IconButton(onClick = {
                                Toast.makeText(context, "Filter", Toast.LENGTH_SHORT).show()
                            }) { Icon(Icons.Default.Info, "Filter") }
                        }
                    },
                    bottomBar = {
                        BottomAppBarExample(
                            onHomeClick = {
                                Toast.makeText(context, "Home clicked", Toast.LENGTH_SHORT).show()
                            },
                            onFavoriteClick = {
                                Toast.makeText(context, "Favorite clicked", Toast.LENGTH_SHORT)
                                    .show()
                            },
                            onSettingsClick = {
                                Toast.makeText(context, "Settings clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        )
                    }
                ) { innerPadding ->
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
    val context = LocalContext.current
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
        item { ToggleableExample() }
        item { CheckBoxExample() }
        item { BorderComponent { SelectableExample() } }
        item { BorderComponent { RadioGroupSample() } }
        item { BorderComponent { RadioButtonExample() } }
        item { BorderComponent { IconButtonExample(onRefresh = { onRefresh(context) }) } }
        item { BorderComponent { IconToggleButtonExample() } }
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