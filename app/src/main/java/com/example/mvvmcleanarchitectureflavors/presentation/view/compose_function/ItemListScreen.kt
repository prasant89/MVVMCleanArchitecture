package com.example.mvvmcleanarchitectureflavors.presentation.view.compose_function

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvmcleanarchitectureflavors.data.model.Users
import com.example.mvvmcleanarchitectureflavors.domain.usecase.GetUsersUseCase
import com.example.mvvmcleanarchitectureflavors.presentation.viewmodel.UserViewModel
import com.example.mvvmcleanarchitectureflavors.presentation.viewmodel.UserViewModelFactory
import com.prasant.presentation.viewstate.UserViewState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card


@Composable
fun ItemListScreen (getUsersUseCase: GetUsersUseCase){
    // Create a ViewModel using the custom factory
    val userViewModel: UserViewModel = viewModel(factory = UserViewModelFactory(getUsersUseCase))
    val userViewState = userViewModel.state.collectAsState().value

    when(userViewState){
        is UserViewState.Loading ->{
            CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        }
        is UserViewState.Error -> {
            Text(
                text = userViewState.error.message ?: "Unknown error",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(16.dp)
            )
        }
        is UserViewState.Success -> {
            SuccessScreen(users = userViewState.users)
        }

    }
}

@Composable
fun SuccessScreen(users: List<Users>) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(users) { user ->
            UserItem(user)
        }
    }
}

@Composable
fun UserItem(user: Users) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = user.name, modifier = Modifier.padding(16.dp),style = MaterialTheme.typography.bodyMedium)
            //Text(text = user.name, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
