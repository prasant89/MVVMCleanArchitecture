package com.prasant.binapani.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.prasant.binapani.presentation.view.screens.compose_function.LoginScreenSwiggy
import com.prasant.binapani.ui.theme.MVVMCleanarchitectureFlavorsTheme

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