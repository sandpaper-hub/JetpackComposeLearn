package com.compose.jetpackcomposelearn.state

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
@Suppress("FunctionName")
fun SimpleUdfExample() {
    var count by rememberSaveable { mutableIntStateOf(0) }
    var logMessages by rememberSaveable { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(12.dp)
            .border(2.dp, MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(8.dp))
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Current count: $count", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {
                count++
                logMessages = logMessages + "Clicked \"+\": count is $count "
            }) {
                Text("+")
            }
            Button(onClick = {
                count--
                logMessages = logMessages + "Clicked \"-\": count is $count"
            }) {
                Text("-")
            }
            Button(onClick = {
                logMessages = logMessages + "Reset count from $count to 0"
                count = 0
            }) {
                Text("Reset")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Log of actions", style = MaterialTheme.typography.titleMedium)
        LogList(logMessages)
    }
}

@Composable
@Suppress("FunctionName")
fun LogList(messages: List<String>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(messages) { msg ->
            Text(
                text = msg,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}