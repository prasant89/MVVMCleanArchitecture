package com.example.mvvmcleanarchitectureflavors.presentation.view.compose_function

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvmcleanarchitectureflavors.presentation.viewmodel.LoginViewModel

@Composable
fun LoginScreenSwiggy (viewModel: LoginViewModel = viewModel()) {
    LoginScreen(
    title = "One app for food, grocery, dining & more in minutes!",
    placeholder = "Enter your number",
    onButtonClick = { viewModel.onContinueClicked() }
    )
}