package com.prasant.binapani.data.remote

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

interface FakeApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val success: Boolean, val message: String)