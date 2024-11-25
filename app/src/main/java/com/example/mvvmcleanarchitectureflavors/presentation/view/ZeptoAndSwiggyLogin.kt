package com.example.mvvmcleanarchitectureflavors.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.example.mvvmcleanarchitectureflavors.presentation.view.compose_function.LoginScreenSwiggy
import com.example.mvvmcleanarchitectureflavors.presentation.view.compose_function.LoginScreenZepto
import com.example.mvvmcleanarchitectureflavors.ui.theme.MVVMCleanarchitectureFlavorsTheme

class ZeptoAndSwiggyLogin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMCleanarchitectureFlavorsTheme (darkTheme = isSystemInDarkTheme()){
                LoginApp()            }
        }
    }
}

@Composable
fun LoginApp() {
    //LoginScreenZepto()
     LoginScreenSwiggy()
    // LoginScreenZomato()
}