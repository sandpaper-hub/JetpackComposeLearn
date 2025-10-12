package com.compose.jetpackcomposelearn.databaseExample.presentation.ui.editScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.compose.jetpackcomposelearn.databaseExample.presentation.ui.CommonPersonDataInput
import com.compose.jetpackcomposelearn.databaseExample.presentation.ui.CommonTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Suppress("FunctionName")
fun EditScreen(
    onBackNavigation: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CommonTopAppBar(
                navigationAction = onBackNavigation,
                "Edit profile",
                scrollBehavior = null,
                actions = {
                    IconButton(onClick = onBackNavigation) {
                        Icon(Icons.Default.Close, contentDescription = "Dismiss button")
                    }

                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Check, contentDescription = "Save button")
                    }
                }

            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            CommonPersonDataInput(
                modifier = Modifier
                    .padding(16.dp),
                completeAction = { name, age, gender -> },
                buttonVisibility = false
            )
        }
    }
}