package com.prasant.presentation.viewstate

import com.prasant.binapani.data.model.Users

sealed class UserViewState {
    object Loading : UserViewState()
    data class Success(val users: List<Users>) : UserViewState()
    data class Error(val error: Throwable) : UserViewState()
}