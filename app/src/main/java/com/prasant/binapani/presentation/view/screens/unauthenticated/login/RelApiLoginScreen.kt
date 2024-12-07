package com.prasant.binapani.presentation.view.screens.unauthenticated.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prasant.binapani.presentation.view.screens.unauthenticated.login.state.LoginUiEvent
import com.prasant.binapani.presentation.viewmodel.LoginScreenViewModel

@Composable
fun RelApiLoginScreen(loginScreenViewModel: LoginScreenViewModel = hiltViewModel()) {
    // Collecting the login state from ViewModel
    val loginState by remember { mutableStateOf(loginScreenViewModel.loginState) }
    val isLoginSuccessful by loginScreenViewModel.isLoginSuccessful.collectAsState()
    val loginMessage by loginScreenViewModel.loginMessage.collectAsState()

    // Local state for email and password inputs
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login", style = MaterialTheme.typography.body2)

        Spacer(modifier = Modifier.height(16.dp))

        // Email input
        TextField(
            value = email,
            onValueChange = {
                email = it
                loginScreenViewModel.onUiEvent(LoginUiEvent.EmailOrMobileChanged(it))
            },
            label = { Text("Email or Mobile") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Password input
        TextField(
            value = password,
            onValueChange = {
                password = it
                loginScreenViewModel.onUiEvent(LoginUiEvent.PasswordChanged(it))
            },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Login button
        Button(onClick = { loginScreenViewModel.onUiEvent(LoginUiEvent.Submit) }) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display success or error message
        when {
            isLoginSuccessful -> {
                Text("Success: $loginMessage")
            }
            loginMessage.isNotEmpty() -> {
                Text("Error: $loginMessage")
            }
        }
    }
}
