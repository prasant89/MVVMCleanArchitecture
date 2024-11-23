package com.example.mvvmcleanarchitectureflavors.domain.usecase

import com.example.mvvmcleanarchitectureflavors.data.model.Users
import com.example.mvvmcleanarchitectureflavors.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase (private val repository: UserRepository){
    operator fun invoke():Flow<List<Users>> = repository.getUser()
}