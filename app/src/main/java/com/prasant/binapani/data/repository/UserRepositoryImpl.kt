package com.prasant.binapani.data.repository

import com.prasant.binapani.data.model.Users
import com.prasant.binapani.data.remote.FakeApiService
import com.prasant.binapani.data.remote.LoginRequest
import com.prasant.binapani.data.remote.LoginResponse
import com.prasant.binapani.domain.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: FakeApiService
) : UserRepository {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getUser(): Flow<List<Users>> {
        return flow {
            emit(
                listOf(
                    Users(1, "Prasant Kumar Pradhan"),
                    Users(2, "Sigma Sahoo"),
                    Users(3, "Sarita Das")
                )
            )
        }.flatMapConcat { initialList ->
            flow {
                val items = List(20) { Users(it + 4, "User Item #$it") }
                emit(initialList + items)
            }
        }
    }

    override suspend fun loginUser(request: LoginRequest): Response<LoginResponse> {
        return apiService.login(request)
    }
}
