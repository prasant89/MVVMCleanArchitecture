package com.example.mvvmcleanarchitectureflavors.di

import com.example.mvvmcleanarchitectureflavors.data.repository.UserRepositoryImpl
import com.example.mvvmcleanarchitectureflavors.domain.repository.UserRepository
import com.example.mvvmcleanarchitectureflavors.domain.usecase.GetUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUserRepository(): UserRepository {
        return UserRepositoryImpl() // Replace with your actual repository implementation
    }

    @Provides
    fun provideGetUsersUseCase(repository: UserRepository): GetUsersUseCase {
        return GetUsersUseCase(repository)
    }
}