package com.compose.jetpackcomposelearn.databaseExample.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExpandedFullScreenSearchBar
import androidx.compose.runtime.Composable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SearchBarState
import androidx.compose.material3.SearchBarValue
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.unit.dp
import com.compose.jetpackcomposelearn.databaseExample.domain.model.Person
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
@Suppress("FunctionName")
fun PersonSearchBar(
    state: SearchBarState,
    people: List<Person>,
    onQueryChange: (String) -> Unit,
    modifier: Modifier
) {
    val textFieldState = rememberTextFieldState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(textFieldState) {
        snapshotFlow { textFieldState.text.toString() }
            .distinctUntilChanged()
            .collectLatest { onQueryChange(it) }
    }

    val inputField =
        @Composable {
            SearchBarDefaults.InputField(
                searchBarState = state,
                textFieldState = textFieldState,
                onSearch = {
                    scope.launch {
                        state.animateToCollapsed()
                    }
                },
                placeholder = {
                    Text(modifier = Modifier.clearAndSetSemantics {}, text = "Search")
                },
                leadingIcon = {
                    if (state.currentValue == SearchBarValue.Expanded) {
                        TooltipBox(
                            positionProvider =
                                TooltipDefaults.rememberTooltipPositionProvider(
                                    TooltipAnchorPosition.Above
                                ), tooltip = { PlainTooltip { Text("Back") } },
                            state = rememberTooltipState()
                        ) {
                            IconButton(onClick = { scope.launch { state.animateToCollapsed() } }) {
                                Icon(
                                    Icons.AutoMirrored.Default.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        }
                    } else {
                        Icon(Icons.Default.Search, contentDescription = null)
                    }
                },
                trailingIcon = { Icon(Icons.Default.MoreVert, contentDescription = null) }
            )
        }

    ExpandedFullScreenSearchBar(state = state, inputField = inputField) {
        SearchResultsList(people = people,
            onPersonClick = {person ->
                textFieldState.setTextAndPlaceCursorAtEnd(person.name)
                scope.launch { state.animateToCollapsed() }
            })
    }
}

@Composable
private fun SearchResultsList(
    people: List<Person>,
    onPersonClick: (Person) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        if (people.isEmpty()) {
            ListItem(
                headlineContent = { Text("Nothings found") },
                colors = ListItemDefaults.colors(containerColor = Color.Transparent),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            return@Column
        }
        people.forEach { person ->
            ListItem(
                headlineContent = { Text(person.name) },
                supportingContent = { Text("Age: ${person.age}") },
                colors = ListItemDefaults.colors(Color.Transparent),
                modifier = Modifier
                    .clickable { onPersonClick(person) }
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp)
            )
        }
    }
}