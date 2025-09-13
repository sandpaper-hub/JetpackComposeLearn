package com.compose.jetpackcomposelearn.databaseExample.presentation.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.jetpackcomposelearn.databaseExample.data.database.entities.Person
import com.compose.jetpackcomposelearn.databaseExample.domain.interactor.PersonInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonsViewModel @Inject constructor(
    private val personInteractor: PersonInteractor,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val uiState = personInteractor.observeAll()
        .stateIn(viewModelScope, SharingStarted.Companion.WhileSubscribed(5000), emptyList())


    fun addPerson(person: Person) {
        viewModelScope.launch {
            personInteractor.addPerson(person)
        }
    }
}