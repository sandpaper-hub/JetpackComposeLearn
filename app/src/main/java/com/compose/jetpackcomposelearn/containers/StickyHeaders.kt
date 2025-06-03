package com.compose.jetpackcomposelearn.containers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Suppress("FunctionName")
fun StickyHeadersExample() {
    val phones = listOf(
        "Apple iPhone 15 Pro",
        "Realme 11 PRO",
        "Google Pixel 5",
        "Samsung Galaxy S24 Ultra",
        "Samsung Galaxy S21 FE",
        "Apple iPhone 15 Pro Max",
        "Xioami Redmi Note 12",
        "Xiaomi Redmi 12",
        "Apple iPhone 13",
        "Google Pixel 6",
        "Apple iPhone 14",
        "Realme C30s",
        "Realme Note 50"
    )

    val groups = phones.groupBy { it.substringBefore(" ") }

    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .border(2.dp, MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text("StickyHeader example")
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp)
        ) {
            groups.forEach { brand, models ->
                stickyHeader {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(4.dp))
                            .padding(8.dp)
                    ) {
                        Text(brand.toString(), style = MaterialTheme.typography.titleMedium)
                    }
                }

                items(models, key = { it }) { model ->
                    Text(
                        model, modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp, horizontal = 16.dp)
                    )
                }
            }
        }
    }
}