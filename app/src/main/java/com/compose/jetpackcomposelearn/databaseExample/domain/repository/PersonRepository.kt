package com.compose.jetpackcomposelearn.databaseExample.domain.repository

import com.compose.jetpackcomposelearn.databaseExample.domain.model.Person
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    fun observeAll(): Flow<List<Person>>
    fun getPersonsByName(personName: String): Flow<List<Person>>

    suspend fun getPersonById(personId: Long): Person
    suspend fun addPerson(person: Person): Long
    suspend fun deletePerson(id: Long)
    suspend fun clearDatabase()
}