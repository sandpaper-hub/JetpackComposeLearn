package com.compose.jetpackcomposelearn.databaseExample.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Suppress("FunctionName")
fun PersonsScreen(modifier: Modifier) {
    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val (lazyColumn, clearButton) = createRefs()

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .constrainAs(lazyColumn) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }) {

        }

        Button(onClick = {}, modifier = Modifier
            .constrainAs(clearButton) {
                linkTo(start = parent.start, end = parent.end)
                bottom.linkTo(parent.bottom)
            }
            .padding(bottom = 12.dp)) {
            Text("Clear")
        }
    }
}
