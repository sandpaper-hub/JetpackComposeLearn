package com.compose.jetpackcomposelearn.databaseExample.presentation.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Suppress("FunctionName")
fun CommonTopAppBar(
    navigationAction: (() -> Unit)? = null,
    title: String,
    scrollBehavior: TopAppBarScrollBehavior?,
    actions: @Composable (() -> Unit)? = null
) {
    TopAppBar(
        navigationIcon = {
            if (navigationAction != null) {
                IconButton(onClick = navigationAction) {
                    Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Back")
                }
            }
        },
        title = { Text(title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
        scrollBehavior = scrollBehavior,
        actions = {
            actions?.invoke()
        }
    )
}