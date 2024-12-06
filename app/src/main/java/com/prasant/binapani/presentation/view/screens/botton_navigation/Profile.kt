package com.prasant.binapani.presentation.view.screens.botton_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun  Profile(navController: NavController) {
    ScreenContent(
        title = "Welcome to Profile Screen",
        description = "Experienced Android developer with 7 years in designing and implementing user-friendly mobile applications. Proficient in Java and Kotlin, with a strong grasp of Android SDK and APIs. Skilled in using modern frameworks like Jetpack and integrating RESTful services. Proven ability to collaborate with cross-functional teams to deliver high-quality software solutions on time.",
        backgroundColor = Color(0xFF1374BB),
        navController = navController
    )
}