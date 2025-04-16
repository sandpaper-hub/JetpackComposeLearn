package com.compose.jetpackcomposelearn.modifierPack

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ModifierDefault(text: String, modifier: Modifier = Modifier.fillMaxWidth().padding(10.dp)) {
    Text(text, modifier, fontSize = 18.sp, textAlign = TextAlign.Center)
}

@Composable
fun ModifierOverriding(text: String, modifier: Modifier = Modifier.fillMaxWidth().padding(10.dp)) {
    Text(text, modifier, fontSize = 18.sp, textAlign = TextAlign.Center)
}

@Composable
fun ModifierMerging(text: String, modifier: Modifier) {
    val defaultModifier = Modifier.fillMaxWidth().padding(10.dp)
    Text(text, defaultModifier.then(modifier), fontSize = 18.sp, textAlign = TextAlign.Center)
}