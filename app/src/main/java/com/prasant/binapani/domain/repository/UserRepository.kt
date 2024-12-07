package com.prasant.binapani.domain.repository

import com.prasant.binapani.data.model.Users
import com.prasant.binapani.data.remote.LoginRequest
import com.prasant.binapani.data.remote.LoginResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface UserRepository {
    fun getUser(): Flow<List<Users>>
    suspend fun loginUser(request: LoginRequest): Response<LoginResponse>

}