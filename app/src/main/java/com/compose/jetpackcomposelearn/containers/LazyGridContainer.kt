package com.compose.jetpackcomposelearn.containers

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyHorizontalGridExample() {
    val numbersList = (0..12).toList()

    Column(
        modifier = Modifier
            .padding(12.dp).fillMaxWidth().border(
                2.dp,
                MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(8.dp)
            ).padding(16.dp)
    ) {
        Text("LazyHorizontalGrid example")
        LazyHorizontalGrid(
            rows = GridCells.Fixed(3), modifier = Modifier
                .fillMaxWidth().height(200.dp)
        ) {
            items(numbersList) { number ->
                Card(
                    modifier = Modifier
                        .size(100.dp, 60.dp)
                        .padding(8.dp),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Item $number", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun LazyVerticalGridExample() {
    val numberList = (0..12).toList()

    Column(
        modifier = Modifier
            .padding(12.dp).fillMaxWidth().border(
                2.dp, MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(8.dp)
            ).padding(16.dp)
    ) {
        Text("LazyVerticalGrid example")
        LazyVerticalGrid(
            columns = GridCells.Fixed(3), modifier = Modifier
                .fillMaxWidth().height(160.dp)
        ) {
            items(numberList) { number ->
                Card(
                    modifier = Modifier
                        .size(100.dp, 60.dp)
                        .padding(8.dp),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    colors = CardDefaults.cardColors(
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Item $number", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
                    }
                }
            }

        }
    }
}