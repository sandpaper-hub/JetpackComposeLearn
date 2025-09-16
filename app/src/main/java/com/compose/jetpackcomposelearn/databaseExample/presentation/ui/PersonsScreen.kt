package com.compose.jetpackcomposelearn.databaseExample.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    var showSheet by remember { mutableStateOf(false) }

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
                showSheet = true
            }, modifier = Modifier
                .constrainAs(addButton) {
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .padding(end = 48.dp, bottom = 48.dp)) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }

        if (showSheet) {
            AddPersonBottomSheet(
                true,
                onDismiss = { showSheet = false },
                onAdd = { name, age, gender ->
                    viewModel.addPerson(Person(name = name, age = age.toInt(), gender = true))
                    showSheet = false
                })
        }
    }
}