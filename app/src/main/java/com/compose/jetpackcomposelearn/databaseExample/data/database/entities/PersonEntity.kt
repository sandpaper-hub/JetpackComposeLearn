package com.compose.jetpackcomposelearn.databaseExample.data.database.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "people",
    indices = [Index(value = ["name"], unique = false)]
)
data class PersonEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val age: Int,
    val gender: Boolean,
    val createdAt: Long = System.currentTimeMillis()
)