package com.prasant.binapani.domain.repository

import com.prasant.binapani.data.model.Users
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(): Flow<List<Users>>
}