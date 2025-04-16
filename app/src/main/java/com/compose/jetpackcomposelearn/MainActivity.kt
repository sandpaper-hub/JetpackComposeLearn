package com.compose.jetpackcomposelearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.compose.jetpackcomposelearn.modifierPack.BorderExample
import com.compose.jetpackcomposelearn.modifierPack.ClickableExample
import com.compose.jetpackcomposelearn.modifierPack.ClipExample
import com.compose.jetpackcomposelearn.modifierPack.ColorExample
import com.compose.jetpackcomposelearn.modifierPack.ModifierBasicExample
import com.compose.jetpackcomposelearn.modifierPack.PaddingExample
import com.compose.jetpackcomposelearn.modifierPack.ScrollExample
import com.compose.jetpackcomposelearn.modifierPack.ShadowExample
import com.compose.jetpackcomposelearn.modifierPack.SizeExample
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
fun MainExample(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ModifierBasicExample()
        ColorExample()
        SizeExample()
        PaddingExample()
        ScrollExample()
        BorderExample()
        ClipExample()
        ShadowExample()
        ClickableExample()
    }
}

@Preview(name = "Galaxy S23 Plus", widthDp = 393, heightDp = 851)
@Composable
fun MainExamplePreview() {
    JetpackComposeLearnTheme {
        MainExample()
    }
}