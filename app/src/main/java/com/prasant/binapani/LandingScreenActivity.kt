package com.prasant.binapani

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.prasant.binapani.ui.theme.MyAppTheme
import com.prasant.binapani.presentation.view.screens.NavigationRoutes
import com.prasant.binapani.presentation.navigation.authenticatedGraph
import com.prasant.binapani.presentation.navigation.splashScreen
import com.prasant.binapani.presentation.navigation.unauthenticatedGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
class LandingScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                   /* val navController = rememberNavController()
                    SetupNavGraph(navController = navController)   */
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        MainAppNavHost()
    }

}

@Composable
fun MainAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationRoutes.RegisterSplashScreen.SplashScreen.route

    ) {

        // SplashScreen user flow screens
        splashScreen(navController = navController)

        // Unauthenticated user flow screens
        unauthenticatedGraph(navController = navController)

        // Authenticated user flow screens
        authenticatedGraph(navController = navController)
    }
}


