package com.prasant.binapani.presentation.view.screens.botton_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun  Setting(navController: NavController) {
    ScreenContent(
        title = "Welcome to Setting Screen",
        description = "Proficient in Java and Kotlin for Android development, with strong expertise in Android SDK and modern frameworks like Jetpack. Skilled in integrating RESTful APIs and managing databases using SQLite and Room. Experienced in UI/UX design, ensuring intuitive user interfaces. Familiar with Agile methodologies and version control using Git for efficient collaboration.",
        backgroundColor = Color(0xFF8CD923),
        navController = navController
    )
}