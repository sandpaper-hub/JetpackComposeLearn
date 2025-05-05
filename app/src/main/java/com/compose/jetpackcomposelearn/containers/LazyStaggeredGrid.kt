package com.compose.jetpackcomposelearn.containers

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
@Suppress("FunctionName")
fun LazyVerticalStaggeredGridExample() {
    val numbers = (0..15).toList()

    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .height(300.dp)
            .border(2.dp, MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text("LazyVerticalStaggeredGrid Example")
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalItemSpacing = 8.dp
        ) {
            items(numbers, key = { it }) { number ->
                val elementHeight = (50 + (0..150).random())
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(elementHeight.dp)
                        .background(
                            MaterialTheme.colorScheme.primaryContainer,
                            RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("$number element\n$elementHeight dp")
                }
            }
        }
    }
}

@Composable
@Suppress("FunctionName")
fun LazyHorizontalStaggeredGridExample() {
    val numbers = (0..15).toList()

    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .height(300.dp)
            .border(2.dp, MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text("LazyHorizontalStaggeredGrid Example")
        LazyHorizontalStaggeredGrid(
            rows = StaggeredGridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalItemSpacing = 8.dp
        ) {
            items(numbers, key = { it }) { number ->
                val elementWidth = (50 + (0..150).random())
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(elementWidth.dp)
                        .background(
                            MaterialTheme.colorScheme.primaryContainer,
                            RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("$number element\n$elementWidth dp")
                }
            }
        }
    }
}

