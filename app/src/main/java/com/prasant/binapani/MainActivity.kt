package com.prasant.binapani

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.prasant.binapani.data.repository.UserRepositoryImpl
import com.prasant.binapani.domain.usecase.GetUsersUseCase
import com.prasant.binapani.presentation.view.screens.compose_function.ItemListScreen
import com.prasant.binapani.ui.theme.MVVMCleanarchitectureFlavorsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.statusBarColor = Color.Cyan.toArgb()
        setContent {
            MVVMCleanarchitectureFlavorsTheme {
                MaterialTheme {
                    Scaffold(
                        topBar = {
                            // Custom Action Bar
                            TopAppBar(
                                title = { Text("Mvvm clean architecture") },
                                actions = {
                                    IconButton(onClick = { /* Handle action */ }) {
                                        Icon(
                                            Icons.Default.Favorite,
                                            contentDescription = "Favorite"
                                        )
                                    }
                                    IconButton(onClick = { /* Handle action */ }) {
                                        Icon(
                                            Icons.Default.Settings,
                                            contentDescription = "Settings"
                                        )
                                    }
                                },
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = Color.Blue, // Set the background color
                                    titleContentColor = Color.White, // Set the title color
                                    actionIconContentColor = Color.White // Set the action icon color
                                )
                            )
                        },
                        content = { paddingValues ->
                            MainContent(modifier = Modifier.padding(paddingValues))

                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(0.dp)) {
            ItemListScreen(getUsersUseCase = GetUsersUseCase(repository = UserRepositoryImpl()))
        }
    }
}


