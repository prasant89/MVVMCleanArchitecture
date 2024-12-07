package com.prasant.binapani.domain.usecase

import com.prasant.binapani.domain.repository.UserRepository

class ValidatePasswordUseCase(private val userRepository: UserRepository) {

    fun execute(password: String): Boolean {
        // Password validation logic (e.g., min length of 6)
        return password.length >= 6
    }
}