package com.prasant.binapani.domain.usecase

import com.prasant.binapani.data.model.Users
import com.prasant.binapani.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase (private val repository: UserRepository){
    operator fun invoke():Flow<List<Users>> = repository.getUser()
}