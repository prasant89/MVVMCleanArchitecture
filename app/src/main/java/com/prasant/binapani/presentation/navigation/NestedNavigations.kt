package com.prasant.binapani.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.prasant.binapani.presentation.view.screens.NavigationRoutes
import com.prasant.binapani.presentation.view.screens.botton_navigation.BottomNavigationApp
import com.prasant.binapani.presentation.view.screens.compose_function.SplashScreen
import com.prasant.binapani.presentation.view.screens.dashboard.DashboardScreen
import com.prasant.binapani.presentation.view.screens.unauthenticated.login.LoginScreen
import com.prasant.binapani.presentation.view.screens.unauthenticated.login.RelApiLoginScreen
import com.prasant.binapani.presentation.view.screens.unauthenticated.registration.RegistrationScreen

// Navigation function for unauthenticated screens
fun NavGraphBuilder.unauthenticatedGraph(navController: NavController) {
    navigation(
        route = NavigationRoutes.Unauthenticated.NavigationRoute.route,
        startDestination = NavigationRoutes.Unauthenticated.Login.route
    ) {
        composable(NavigationRoutes.Unauthenticated.Login.route) {
           LoginScreen(
                onNavigateToRegistration = { navController.navigateTo(NavigationRoutes.Unauthenticated.Registration.route) },
                onNavigateToForgotPassword = {}, // Add functionality later
                onNavigateToAuthenticatedRoute = { navController.navigateToAuthenticated() }
            )

           // RelApiLoginScreen()
        }

        composable(NavigationRoutes.Unauthenticated.Registration.route) {
            RegistrationScreen(
                onNavigateBack = { navController.navigateUp() },
                onNavigateToAuthenticatedRoute = { navController.navigateToAuthenticated() }
            )
        }
    }
}

// Navigation function for the splash screen
fun NavGraphBuilder.splashScreen(navController: NavController) {
    composable(NavigationRoutes.RegisterSplashScreen.SplashScreen.route) {
        SplashScreen(
            onNavigateToLogin = {
                navController.navigateTo(
                    route = NavigationRoutes.Unauthenticated.Login.route,
                    popUpToRoute = NavigationRoutes.RegisterSplashScreen.SplashScreen.route
                )
            }
        )
    }
}

// Navigation function for authenticated screens display with  BottomNavigationApp
fun NavGraphBuilder.authenticatedGraph(navController: NavController) {
    navigation(
        route = NavigationRoutes.Authenticated.NavigationRoute.route,
        startDestination = NavigationRoutes.Authenticated.Dashboard.route
    ) {
        composable(route = NavigationRoutes.Authenticated.Dashboard.route) {
            BottomNavigationApp()
        }
    }
}

// Extension function to navigate with optional pop-up-to logic
private fun NavController.navigateTo(route: String, popUpToRoute: String? = null, inclusive: Boolean = true) {
    navigate(route) {
        popUpToRoute?.let {
            popUpTo(it) { this.inclusive = inclusive }
        }
    }
}

// Extension function to navigate directly to the authenticated graph
private fun NavController.navigateToAuthenticated() {
    navigateTo(
        route = NavigationRoutes.Authenticated.NavigationRoute.route,
        popUpToRoute = NavigationRoutes.Unauthenticated.NavigationRoute.route
    )
}
