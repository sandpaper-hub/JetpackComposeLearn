package com.compose.jetpackcomposelearn.databaseExample.domain.interactor

import com.compose.jetpackcomposelearn.databaseExample.domain.model.Person
import kotlinx.coroutines.flow.Flow

interface PersonInteractor {
    fun observeAll(): Flow<List<Person>>
    fun getPersonByName(personName: String): Flow<List<Person>>
    suspend fun addPerson(person: Person): Long
    suspend fun deletePerson(id: Long)
    suspend fun clearDatabase()
}