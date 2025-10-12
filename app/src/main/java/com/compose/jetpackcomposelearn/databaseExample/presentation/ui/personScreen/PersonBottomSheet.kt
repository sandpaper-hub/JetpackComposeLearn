package com.compose.jetpackcomposelearn.databaseExample.presentation.ui.personScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.compose.jetpackcomposelearn.databaseExample.presentation.ui.CommonPersonDataInput

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Suppress("FunctionName")
fun AddPersonBottomSheet(
    showSheet: Boolean, onDismiss: () -> Unit, onAdd: (String, String, Boolean) -> Unit
) {
    if (showSheet) {
        ModalBottomSheet(onDismissRequest = onDismiss) {
            CommonPersonDataInput(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                completeAction = onAdd,
                buttonVisibility = true
            )
        }
    }
}