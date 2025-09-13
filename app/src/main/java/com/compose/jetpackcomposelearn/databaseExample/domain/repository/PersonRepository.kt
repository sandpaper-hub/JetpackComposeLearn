package com.compose.jetpackcomposelearn.databaseExample.domain.repository

import com.compose.jetpackcomposelearn.databaseExample.data.database.entities.Person
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    fun observeAll(): Flow<List<Person>>
    suspend fun getPersonById(id: Long): Person?
    suspend fun addPerson(person: Person): Long
    suspend fun deletePerson(id: Long)
    suspend fun clearDatabase()
}