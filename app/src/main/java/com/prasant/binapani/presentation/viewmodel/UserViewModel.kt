package com.prasant.binapani.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prasant.binapani.domain.usecase.GetUsersUseCase
import com.prasant.presentation.viewstate.UserViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
):ViewModel() {
    private val _state = MutableStateFlow<UserViewState>(UserViewState.Loading)
    val state: StateFlow<UserViewState> get() = _state

    init {
        getUsers()
    }

    private fun getUsers(){
        viewModelScope.launch {
            getUsersUseCase()
                .catch { e -> _state.value = UserViewState.Error(e) }
                .collect { users -> _state.value = UserViewState.Success(users) }
        }
    }

}