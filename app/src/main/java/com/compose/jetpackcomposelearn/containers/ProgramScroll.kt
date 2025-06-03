package com.compose.jetpackcomposelearn.containers

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
@Suppress("FunctionName")
fun ProgramScrollExample() {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val numbers = (0..20).toList()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .border(2.dp, MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(8.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("ProgramScroll example")
        Button(modifier = Modifier.padding(start = 0.dp, top = 12.dp), onClick = {
            scope.launch {
                scrollState.animateScrollTo(scrollState.maxValue)
            }
        }) {
            Text("Scroll")
        }
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .height(300.dp)
                .verticalScroll(scrollState)
        ) {
            numbers.forEach { number ->
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                ) {
                    Text("Element $number", modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}