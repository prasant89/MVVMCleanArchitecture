package com.prasant.binapani.domain.usecase

import com.prasant.binapani.data.remote.LoginRequest
import com.prasant.binapani.data.remote.LoginResponse
import com.prasant.binapani.domain.repository.UserRepository
import javax.inject.Inject
import retrofit2.Response

class ValidateUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend fun execute(email: String, password: String): Response<LoginResponse> {
        val request = LoginRequest(email, password)
        return repository.loginUser(request)
    }
}