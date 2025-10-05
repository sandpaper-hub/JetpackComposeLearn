package com.compose.jetpackcomposelearn.databaseExample.presentation.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.jetpackcomposelearn.databaseExample.domain.interactor.PersonInteractor
import com.compose.jetpackcomposelearn.databaseExample.domain.model.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val personInteractor: PersonInteractor, savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val personId: Long =
        checkNotNull(savedStateHandle["personId"]) { "personId is required" }

    data class UiState(
        val loading: Boolean = true,
        val data: Person? = null,
        val error: String? = null
    )

    private val _ui = MutableStateFlow(UiState())
    val ui: StateFlow<UiState> = _ui

    init {
        initialPerson()
    }

    fun initialPerson() = viewModelScope.launch {
        _ui.value = UiState(loading = true)
        try {
            val person = personInteractor.getPersonById(personId)
            _ui.value = UiState(loading = false, data = person, error = null)
        } catch (t: Throwable) {
            _ui.value = UiState(loading = false, error = t.message)
        }
    }
}