package com.prasant.binapani.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
// Light theme colors
val LightPrimary = Color(0xFF6200EE) // Purple 500
val LightOnPrimary = Color(0xFFFFFFFF) // White
val LightBackground = Color(0xFFF3F3F3) // Light gray

// Dark theme colors
val DarkPrimary = Color(0xFFBB86FC) // Purple 200
val DarkOnPrimary = Color(0xFF000000) // Black
val DarkBackground = Color(0xFF121212) // Dark gray

val LightColorPalette = lightColorScheme(
    primary = Color(0xFF6200EE),
    onPrimary = Color.White,
    secondary = Color(0xFF03DAC5),
    onSecondary = Color.Black,
    background = Color(0xFFF5F5F5),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black
)

val DarkColorPalette = darkColorScheme(
    primary = Color(0xFFBB86FC),
    onPrimary = Color.Black,
    secondary = Color(0xFF03DAC5),
    onSecondary = Color.Black,
    background = Color(0xFF121212),
    onBackground = Color.White,
    surface = Color(0xFF1C1C1E),
    onSurface = Color.White
)