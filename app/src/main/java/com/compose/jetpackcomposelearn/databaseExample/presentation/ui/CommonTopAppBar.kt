package com.compose.jetpackcomposelearn.databaseExample.presentation.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Suppress("FunctionName")
fun CommonTopAppBar(
    title: String,
    scrollBehavior: TopAppBarScrollBehavior,
    actions: @Composable (() -> Unit)? = null
) {
    TopAppBar(
        title = { Text(title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
        scrollBehavior = scrollBehavior,
        actions = {
            actions?.invoke()
        }
    )
}