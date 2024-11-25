package com.example.mvvmcleanarchitectureflavors.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State

class LoginViewModel : ViewModel(){
    private val _phoneNumber = mutableStateOf("")
    val phoneNumber: State<String> = _phoneNumber

    fun onPhoneNumberChanged(newNumber: String) {
        _phoneNumber.value = newNumber
    }

    fun onContinueClicked() {
        // Handle continue button click
    }
}