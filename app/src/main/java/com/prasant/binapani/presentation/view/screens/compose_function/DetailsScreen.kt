package com.prasant.binapani.presentation.view.screens.compose_function

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DetailsScreen(onBack: () -> Unit = {}) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Details Screen")
        Button(onClick = onBack) {
            Text("Go Back")
        }
    }
}