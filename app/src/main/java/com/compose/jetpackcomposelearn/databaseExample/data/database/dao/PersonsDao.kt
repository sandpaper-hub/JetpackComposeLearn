package com.compose.jetpackcomposelearn.databaseExample.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.compose.jetpackcomposelearn.databaseExample.data.database.entities.PersonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonsDao {
    @Query("SELECT * FROM people ORDER BY createdAt DESC")
    fun observeAll(): Flow<List<PersonEntity>>

    @Query("SELECT * FROM people WHERE name = :personName")
    fun getPersonsByName(personName: String): Flow<List<PersonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(person: PersonEntity): Long

    @Query("DELETE FROM people WHERE id = :personId")
    suspend fun delete(personId: Long)

    @Query("DELETE FROM people")
    suspend fun clear()
}