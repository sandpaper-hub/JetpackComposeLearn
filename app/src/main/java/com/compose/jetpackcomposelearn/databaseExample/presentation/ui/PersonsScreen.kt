package com.compose.jetpackcomposelearn.databaseExample.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.compose.jetpackcomposelearn.databaseExample.domain.model.Person
import com.compose.jetpackcomposelearn.databaseExample.presentation.viewModel.PersonsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Suppress("FunctionName")
fun PersonsScreen(
    viewModel: PersonsViewModel = hiltViewModel()
) {
    val persons = viewModel.uiState.collectAsState().value
    var showSheet by remember { mutableStateOf(false) }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PersonTopAppBar(
                scrollBehavior, clearDatabaseAction = viewModel::clearDatabase
            )
        }) { innerPadding ->
        ConstraintLayout(
            Modifier
                .padding(innerPadding)
                .then(Modifier.fillMaxSize())
        ) {
            val (lazyColumn, addButton) = createRefs()

            PersonsList(
                persons,
                onDelete = {person -> viewModel.removePerson(person)},
                modifier = Modifier
                    .constrainAs(lazyColumn) {
                        linkTo(start = parent.start, end = parent.end)
                        linkTo(top = parent.top, bottom = parent.bottom)
                    })

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
                        viewModel.addPerson(Person(name = name, age = age.toInt(), gender = gender))
                        showSheet = false
                    })
            }
        }
    }
}