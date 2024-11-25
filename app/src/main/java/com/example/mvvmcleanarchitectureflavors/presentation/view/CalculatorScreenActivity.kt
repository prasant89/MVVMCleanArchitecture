package com.example.mvvmcleanarchitectureflavors.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mvvmcleanarchitectureflavors.presentation.view.compose_function.CalculatorScreen
import com.example.mvvmcleanarchitectureflavors.ui.theme.MVVMCleanarchitectureFlavorsTheme


class CalculatorScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMCleanarchitectureFlavorsTheme {
                CalculatorScreen()
            }
        }
    }
}





