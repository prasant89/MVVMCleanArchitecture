package com.prasant.binapani.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import com.prasant.binapani.presentation.view.screens.compose_function.CalculatorScreen
import com.prasant.binapani.ui.theme.MVVMCleanarchitectureFlavorsTheme


class CalculatorScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMCleanarchitectureFlavorsTheme (darkTheme = isSystemInDarkTheme()){
                CalculatorScreen()
            }
        }
    }
}





