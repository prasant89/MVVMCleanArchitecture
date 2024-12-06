package com.jodhpurtechies.composelogin.ui.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.prasant.binapani.presentation.view.screens.compose_function.SplashScreen
import com.jodhpurtechies.composelogin.ui.screens.dashboard.DashboardScreen
import com.prasant.binapani.presentation.view.screens.unauthenticated.login.LoginScreen
import com.prasant.binapani.presentation.view.screens.unauthenticated.registration.RegistrationScreen

/**
 * Login, registration, forgot password screens nav graph builder
 * (Unauthenticated user)
 */
fun NavGraphBuilder.unauthenticatedGraph(navController: NavController) {
    navigation(
        route = NavigationRoutes.Unauthenticated.NavigationRoute.route,
        startDestination = NavigationRoutes.Unauthenticated.Login.route
    ) {
        // Login Screen
        composable(NavigationRoutes.Unauthenticated.Login.route) {
            LoginScreen(
                onNavigateToRegistration = {
                    navController.navigate(NavigationRoutes.Unauthenticated.Registration.route)
                },
                onNavigateToForgotPassword = {}, // Add functionality later
                onNavigateToAuthenticatedRoute = { navigateToAuthenticated(navController) },
            )
        }

        // Registration Screen
        composable(NavigationRoutes.Unauthenticated.Registration.route) {
            RegistrationScreen(
                onNavigateBack = { navController.navigateUp() },
                onNavigateToAuthenticatedRoute = { navigateToAuthenticated(navController) }
            )
        }
    }
}

fun NavGraphBuilder.authenticatedGraph(navController: NavController) {
    navigation(
        route = NavigationRoutes.Authenticated.NavigationRoute.route,
        startDestination = NavigationRoutes.Authenticated.Dashboard.route
    ) {
        composable(NavigationRoutes.Authenticated.Dashboard.route) {
            DashboardScreen()
        }
    }
}

fun NavGraphBuilder.splashScreen(navController: NavController) {
    composable(NavigationRoutes.RegisterSplashScreen.SplashScreen.route) {
        SplashScreen(
            onNavigateToLogin = {
                navController.navigate(NavigationRoutes.Unauthenticated.Login.route) {
                    popUpTo(NavigationRoutes.RegisterSplashScreen.SplashScreen.route) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

// Helper function for navigating to the authenticated graph
private fun navigateToAuthenticated(navController: NavController) {
    navController.navigate(NavigationRoutes.Authenticated.NavigationRoute.route) {
        popUpTo(NavigationRoutes.Unauthenticated.NavigationRoute.route) { inclusive = true }
    }
}