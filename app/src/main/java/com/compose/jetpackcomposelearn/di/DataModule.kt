package com.compose.jetpackcomposelearn.di

import android.content.Context
import androidx.room.Room
import com.compose.jetpackcomposelearn.databaseExample.data.database.AppDatabase
import com.compose.jetpackcomposelearn.databaseExample.data.database.dao.PersonsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.NAME).build()

    @Provides
    fun providePersonDao(database: AppDatabase): PersonsDao = database.personDao()
}