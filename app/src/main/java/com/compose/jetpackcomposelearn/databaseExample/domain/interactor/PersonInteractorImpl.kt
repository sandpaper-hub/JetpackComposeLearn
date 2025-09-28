package com.compose.jetpackcomposelearn.databaseExample.domain.interactor

import com.compose.jetpackcomposelearn.databaseExample.domain.model.Person
import com.compose.jetpackcomposelearn.databaseExample.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonInteractorImpl @Inject constructor(
    private val personRepository: PersonRepository
) : PersonInteractor {
    override fun observeAll() = personRepository.observeAll()
    override fun getPersonByName(personName: String): Flow<List<Person>> =
        personRepository.getPersonsByName(personName)

    override suspend fun addPerson(person: Person) = personRepository.addPerson(person)
    override suspend fun deletePerson(id: Long) = personRepository.deletePerson(id)
    override suspend fun clearDatabase() = personRepository.clearDatabase()
}