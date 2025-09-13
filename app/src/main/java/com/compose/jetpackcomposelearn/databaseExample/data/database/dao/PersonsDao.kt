package com.compose.jetpackcomposelearn.databaseExample.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.compose.jetpackcomposelearn.databaseExample.data.database.entities.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonsDao {
    @Query("SELECT * FROM people ORDER BY createdAt DESC")
    fun observeAll(): Flow<List<Person>>

    @Query("SELECT * FROM people WHERE id = :id")
    suspend fun getById(id: Long): Person?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun add(person: Person): Long

    @Query("DELETE FROM people WHERE id = :personId")
    suspend fun delete(personId: Long)

    @Query("DELETE FROM people")
    suspend fun clear()
}