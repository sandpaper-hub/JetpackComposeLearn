package com.compose.jetpackcomposelearn.databaseExample.data.database.converters

import com.compose.jetpackcomposelearn.databaseExample.data.database.entities.PersonEntity
import com.compose.jetpackcomposelearn.databaseExample.domain.model.Person
import javax.inject.Inject

class PersonDbConverter @Inject constructor() {
    fun map(person: Person): PersonEntity{
        return PersonEntity(
            id = person.id,
            name = person.name,
            age = person.age,
            gender = person.gender,
            createdAt = person.createdAt
        )
    }

    fun map(personEntity: PersonEntity?): Person {
        return Person(
            id = personEntity?.id ?: 0,
            name = personEntity?.name ?: "",
            age = personEntity?.age ?: 0,
            gender = personEntity?.gender ?: false,
            createdAt = personEntity?.createdAt ?: 0
        )
    }
}