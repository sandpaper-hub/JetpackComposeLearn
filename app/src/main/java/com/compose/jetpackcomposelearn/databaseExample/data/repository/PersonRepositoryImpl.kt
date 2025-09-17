package com.compose.jetpackcomposelearn.databaseExample.data.repository

import com.compose.jetpackcomposelearn.databaseExample.data.database.converters.PersonDbConverter
import com.compose.jetpackcomposelearn.databaseExample.data.database.dao.PersonsDao
import com.compose.jetpackcomposelearn.databaseExample.domain.model.Person
import com.compose.jetpackcomposelearn.databaseExample.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(
    private val dao: PersonsDao,
    private val personDbConverter: PersonDbConverter
) : PersonRepository {
    override fun observeAll(): Flow<List<Person>> =
        dao.observeAll().map { it.map(personDbConverter::map) }

    override suspend fun getPersonById(id: Long): Person {
        return personDbConverter.map(dao.getById(id))
    }

    override suspend fun addPerson(person: Person): Long {
        return dao.add(personDbConverter.map(person))
    }

    override suspend fun deletePerson(id: Long) = dao.delete(id)
    override suspend fun clearDatabase() = dao.clear()
}