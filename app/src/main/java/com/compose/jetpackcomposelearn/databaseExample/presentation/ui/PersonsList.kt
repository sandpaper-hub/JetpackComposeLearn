package com.compose.jetpackcomposelearn.databaseExample.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.compose.jetpackcomposelearn.databaseExample.domain.model.Person

@Composable
@Suppress("FunctionName")
fun PersonsList(
    persons: List<Person>,
    onDelete: (Person) -> Unit,
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(persons, key = { it.id }) { person ->
            SwipeToDeleteContainer(
                onConfirmed = { onDelete(person) }
            ) { fraction, target ->
                PersonInfoCard(person)
            }
        }
    }
}