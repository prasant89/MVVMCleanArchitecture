package com.prasant.binapani.presentation.view.screens.compose_function

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prasant.binapani.presentation.viewmodel.LoginViewModel

@Composable
fun LoginScreenZepto(viewModel: LoginViewModel = viewModel()) {
    LoginScreen(
        title = "Groceries delivered in 10 minutes",
        placeholder = "Enter Phone Number",
        onButtonClick = { viewModel.onContinueClicked() }
    )
}