package com.compose.jetpackcomposelearn.di

import com.compose.jetpackcomposelearn.databaseExample.data.repository.PersonRepositoryImpl
import com.compose.jetpackcomposelearn.databaseExample.domain.repository.PersonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBindings {
    @Binds
    @Singleton
    abstract fun bindPersonRepository(
        impl: PersonRepositoryImpl
    ): PersonRepository
}