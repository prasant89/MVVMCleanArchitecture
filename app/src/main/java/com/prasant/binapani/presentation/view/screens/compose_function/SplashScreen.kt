package com.prasant.binapani.presentation.view.screens.compose_function

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.prasant.binapani.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigateToLogin: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
    ) {
        // Load and animate the Lottie animation
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logo))
        val logoAnimationState = animateLottieCompositionAsState(
            composition = composition,
            iterations = 1 // Play the animation only once
        )
        LottieAnimation(
            composition = composition,
            progress = { logoAnimationState.progress }
        )

        // Delay navigation until the animation finishes
        LaunchedEffect(key1 = logoAnimationState.isAtEnd) {
            if (logoAnimationState.isAtEnd && !logoAnimationState.isPlaying) {
                delay(900)
                onNavigateToLogin() // Navigate after animation completes
            }
        }
    }
}


