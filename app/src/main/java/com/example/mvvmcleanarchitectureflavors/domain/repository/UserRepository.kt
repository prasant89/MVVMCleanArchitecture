package com.example.mvvmcleanarchitectureflavors.domain.repository

import com.example.mvvmcleanarchitectureflavors.data.model.Users
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(): Flow<List<Users>>
}