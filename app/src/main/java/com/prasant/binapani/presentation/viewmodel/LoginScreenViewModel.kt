package com.prasant.binapani.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prasant.binapani.domain.usecase.ValidateUserUseCase
import com.prasant.binapani.presentation.state.ErrorState
import com.prasant.binapani.presentation.view.screens.unauthenticated.login.state.LoginErrorState
import com.prasant.binapani.presentation.view.screens.unauthenticated.login.state.LoginState
import com.prasant.binapani.presentation.view.screens.unauthenticated.login.state.LoginUiEvent
import com.prasant.binapani.presentation.view.screens.unauthenticated.login.state.emailOrMobileEmptyErrorState
import com.prasant.binapani.presentation.view.screens.unauthenticated.login.state.passwordEmptyErrorState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for Login Screen
 */
@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val validateUserUseCase: ValidateUserUseCase
) : ViewModel() {

    private val _loginState = mutableStateOf(LoginState())
    val loginState: LoginState
        get() = _loginState.value

    val isLoginSuccessful = MutableStateFlow(false)
    val loginMessage = MutableStateFlow("")

    /**
     * Handles UI events related to login.
     */
    fun onUiEvent(event: LoginUiEvent) {
        when (event) {
            is LoginUiEvent.EmailOrMobileChanged -> handleEmailOrMobileChange(event.inputValue)
            is LoginUiEvent.PasswordChanged -> handlePasswordChange(event.inputValue)
            is LoginUiEvent.Submit -> handleLoginSubmission()
        }
    }

    private fun handleEmailOrMobileChange(input: String) {
        _loginState.value = loginState.copy(
            emailOrMobile = input,
            errorState = loginState.errorState.copy(
                emailOrMobileErrorState = if (input.isNotBlank()) ErrorState() else emailOrMobileEmptyErrorState
            )
        )
    }

    private fun handlePasswordChange(input: String) {
        _loginState.value = loginState.copy(
            password = input,
            errorState = loginState.errorState.copy(
                passwordErrorState = if (input.isNotBlank()) ErrorState() else passwordEmptyErrorState
            )
        )
    }

    private fun handleLoginSubmission() {
        if (validateInputs()) {
            login(email = loginState.emailOrMobile, password = loginState.password)
        }
    }

    /**
     * Validates the inputs for email/mobile and password.
     * @return true if valid, false otherwise.
     */
    private fun validateInputs(): Boolean {
        val emailOrMobile = loginState.emailOrMobile.trim()
        val password = loginState.password.trim()

        return when {
            emailOrMobile.isEmpty() -> {
                updateErrorState(emailOrMobileEmptyErrorState)
                false
            }
            password.isEmpty() -> {
                updateErrorState(passwordEmptyErrorState)
                false
            }
            else -> {
                _loginState.value = loginState.copy(errorState = LoginErrorState())
                true
            }
        }
    }

    private fun updateErrorState(errorState: ErrorState) {
        _loginState.value = loginState.copy(
            errorState = loginState.errorState.copy(
                emailOrMobileErrorState = errorState.takeIf { errorState == emailOrMobileEmptyErrorState }
                    ?: loginState.errorState.emailOrMobileErrorState,
                passwordErrorState = errorState.takeIf { errorState == passwordEmptyErrorState }
                    ?: loginState.errorState.passwordErrorState
            )
        )
    }

    /**
     * Handles the login process using the use case.
     */
    fun login(email: String, password: String) {
        viewModelScope.launch {
            val response = validateUserUseCase.execute(email, password)
            if (response.isSuccessful) {
                val body = response.body()
                isLoginSuccessful.value = body?.success == true
                loginMessage.value = body?.message ?: "Login successful"
            } else {
                isLoginSuccessful.value = false
                loginMessage.value = "Login failed: ${response.message()}"
            }
        }
    }
}