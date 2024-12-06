package com.prasant.binapani.presentation.view.screens.botton_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun  More(navController: NavController) {
    ScreenContent(
        title = "Welcome to More Screen",
        description = "Proficient in Java & Kotlin: Extensive experience in building robust applications using both Java and Kotlin programming languages.\n" +
                "UI/UX Design: Strong understanding of Material Design principles, ensuring user-friendly interfaces and seamless navigation.\n" +
                "API Integration: Skilled in integrating RESTful APIs and third-party libraries to enhance app functionality.\n" +
                "Database Management: Experience with SQLite, Room, and Firebase for efficient data storage and retrieval.\n" +
                "Version Control & Collaboration: Proficient in Git and tools like GitHub for version control, enabling effective collaboration in team environments.\n" +
                "Testing & Debugging: Expertise in unit testing and UI testing using JUnit and Espresso for delivering high-quality applications..",
        backgroundColor = Color(0xFFB516EF),
        navController = navController
    )
}