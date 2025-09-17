package com.compose.jetpackcomposelearn.databaseExample.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.compose.jetpackcomposelearn.databaseExample.data.database.dao.PersonsDao
import com.compose.jetpackcomposelearn.databaseExample.data.database.entities.PersonEntity

@Database(
    entities = [PersonEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonsDao

    companion object {
        const val NAME = "app.db"
    }
}