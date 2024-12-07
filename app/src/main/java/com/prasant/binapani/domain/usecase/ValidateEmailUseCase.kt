package com.prasant.binapani.domain.usecase

import com.prasant.binapani.domain.repository.UserRepository

class ValidateEmailUseCase(private val userRepository: UserRepository) {
    fun execute(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}