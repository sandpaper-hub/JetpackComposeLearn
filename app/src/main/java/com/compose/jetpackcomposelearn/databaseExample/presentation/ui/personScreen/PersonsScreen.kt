package com.compose.jetpackcomposelearn.databaseExample.presentation.ui.personScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberSearchBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.jetpackcomposelearn.databaseExample.domain.model.Person
import com.compose.jetpackcomposelearn.databaseExample.presentation.viewModel.PersonsViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Suppress("FunctionName")
fun PersonsScreen(
    onOpenDetails: (personId: Long) -> Unit,
    viewModel: PersonsViewModel = hiltViewModel()
) {
    val persons = viewModel.uiState.collectAsState().value
    var showSheet by remember { mutableStateOf(false) }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val people by viewModel.persons.collectAsStateWithLifecycle()
    val searchBarState = rememberSearchBarState()
    val textFieldState = rememberTextFieldState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(textFieldState) {
        snapshotFlow { textFieldState.text.toString() }
            .distinctUntilChanged()
            .collect { viewModel.onQueryChange(it) }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PersonTopAppBar(
                scrollBehavior, clearDatabaseAction = viewModel::clearDatabase,
                onSearchClick = { scope.launch { searchBarState.animateToExpanded() } }
            )
        }) { innerPadding ->
        ConstraintLayout(
            Modifier
                .padding(innerPadding)
                .then(Modifier.fillMaxSize())
        ) {
            val (lazyColumn, addButton, searchBar) = createRefs()

            PersonSearchBar(
                state = searchBarState,
                people = people,
                onQueryChange = viewModel::onQueryChange,
                onPersonClick = { person -> onOpenDetails(person.id) },
                modifier = Modifier
                    .constrainAs(searchBar) {
                        linkTo(parent.start, parent.end)
                        top.linkTo(parent.top)
                    }
                    .alpha(0f)
                    .sizeIn(1.dp)
            )

            PersonsList(
                persons,
                onDelete = { person -> viewModel.removePerson(person) },
                onPersonClick = { person -> onOpenDetails(person.id) },
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