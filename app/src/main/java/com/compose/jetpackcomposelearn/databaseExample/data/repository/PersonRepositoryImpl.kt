package com.compose.jetpackcomposelearn.databaseExample.data.repository

import com.compose.jetpackcomposelearn.databaseExample.data.database.dao.PersonsDao
import com.compose.jetpackcomposelearn.databaseExample.data.database.entities.Person
import com.compose.jetpackcomposelearn.databaseExample.domain.repository.PersonRepository
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(
    private val dao: PersonsDao
): PersonRepository {
    override fun observeAll() = dao.observeAll()
    override suspend fun getPersonById(id: Long) = dao.getById(id)
    override suspend fun addPerson(person: Person) = dao.add(person)
    override suspend fun deletePerson(id: Long) = dao.delete(id)
    override suspend fun clearDatabase() = dao.clear()
}