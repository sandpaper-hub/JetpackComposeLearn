package com.compose.jetpackcomposelearn.databaseExample.presentation.viewModel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.jetpackcomposelearn.databaseExample.domain.interactor.PersonInteractor
import com.compose.jetpackcomposelearn.databaseExample.domain.model.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonsViewModel @Inject constructor(
    private val personInteractor: PersonInteractor, savedStateHandle: SavedStateHandle
) : ViewModel() {
    val uiState = personInteractor.observeAll()
        .stateIn(viewModelScope, SharingStarted.Companion.WhileSubscribed(5000), emptyList())

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query
    fun onQueryChange(newValue: String) {
        _query.value = newValue
    }

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val persons: StateFlow<List<Person>> =
        _query
            .debounce(300)
            .map { it.trim() }
            .distinctUntilChanged()
            .flatMapLatest { q ->
                if (q.isBlank()) personInteractor.observeAll()
                else personInteractor.getPersonByName(q)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    fun addPerson(person: Person) {
        viewModelScope.launch {
            personInteractor.addPerson(person)
        }
    }

    fun clearDatabase() = viewModelScope.launch { personInteractor.clearDatabase() }

    fun removePerson(person: Person) {
        viewModelScope.launch {
            personInteractor.deletePerson(person.id)
        }
    }
}