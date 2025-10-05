package com.compose.jetpackcomposelearn.databaseExample.presentation.ui.detailScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextOverflow
import com.compose.jetpackcomposelearn.databaseExample.presentation.ui.CommonTopAppBar
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Suppress("FunctionName")
fun DetailTopAppBar(
    personName: String,
    scrollBehavior: TopAppBarScrollBehavior,
    onEdit: () -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }

    CommonTopAppBar(personName, scrollBehavior, actions = {
        Box {
            IconButton(onClick = { menuExpanded = true }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Context menu")
            }
        }

        DropdownMenu(
            expanded = menuExpanded,
            onDismissRequest = { menuExpanded = false }) {
            DropdownMenuItem(
                onClick = {
                    onEdit()
                },
                text = { Text("Edit profile") }
            )
        }
    })
}