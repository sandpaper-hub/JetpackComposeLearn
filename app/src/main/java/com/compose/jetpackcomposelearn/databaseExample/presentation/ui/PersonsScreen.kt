package com.compose.jetpackcomposelearn.databaseExample.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.compose.jetpackcomposelearn.databaseExample.data.database.entities.Person
import com.compose.jetpackcomposelearn.databaseExample.presentation.viewModel.PersonsViewModel

@Composable
@Suppress("FunctionName")
fun PersonsScreen(
    modifier: Modifier, viewModel: PersonsViewModel = hiltViewModel()
) {
    val persons = viewModel.uiState.collectAsState().value
    var showDialog by remember { mutableStateOf(false) }

    ConstraintLayout(modifier.then(Modifier.fillMaxSize())) {
        val (lazyColumn, addButton) = createRefs()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(lazyColumn) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }) {
            items(persons, key = { it.id }) { person ->
                Text("${person.name}, age: ${person.age}", modifier = Modifier.padding(16.dp))
            }
        }

        FloatingActionButton(
            onClick = {
                showDialog = true
            }, modifier = Modifier
                .constrainAs(addButton) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .padding(end = 48.dp, bottom = 48.dp)) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }

        if (showDialog) {
            AddPersonDialog(
                onDismiss = { showDialog = false },
                onAdd = { name ->
                    viewModel.addPerson(Person(name = name, age = 12, gender = true))
                    showDialog = false
                }
            )
        }
    }
}

@Composable
@Suppress("FunctionName")
fun AddPersonDialog(
    onDismiss: () -> Unit,
    onAdd: (String) -> Unit
) {
    Dialog(onDismiss) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            tonalElevation = 8.dp,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Input name", style = MaterialTheme.typography.titleMedium)

                var textValue by remember { mutableStateOf("") }

                OutlinedTextField(
                    value = textValue,
                    onValueChange = { textValue = it })

                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }

                    Button(onClick = { onAdd(textValue) }) {
                        Text("Add")
                    }
                }
            }
        }
    }
}
