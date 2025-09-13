package com.compose.jetpackcomposelearn.di

import com.compose.jetpackcomposelearn.databaseExample.domain.interactor.PersonInteractor
import com.compose.jetpackcomposelearn.databaseExample.domain.interactor.PersonInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InteractorBindings {
    @Binds
    @Singleton
    abstract fun bindPersonsInteractor(
        impl: PersonInteractorImpl
    ): PersonInteractor
}