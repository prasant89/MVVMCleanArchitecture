package com.prasant.binapani.presentation.view.screens.botton_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun  Home(navController: NavController) {
    ScreenContent(
        title = "Welcome to Home Screen",
        description = "With over 7 years of experience in Android development, I specialize in creating robust and user-friendly mobile applications. My expertise includes Kotlin, Java, and the latest Android SDKs. I have a proven track record of delivering high-quality apps that enhance user engagement and drive business growth. I am passionate about staying updated with industry trends and best practices. Let's build something amazing together!.",
        backgroundColor = Color(0xFFE3F2FD),
        navController = navController
    )
}