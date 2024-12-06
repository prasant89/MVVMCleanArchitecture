package com.prasant.binapani.presentation.view.screens

sealed class NavigationRoutes {

    // Unauthenticated Routes
    sealed class Unauthenticated(val route: String) : NavigationRoutes() {
        object NavigationRoute : Unauthenticated(route = "unauthenticated")
        object Login : Unauthenticated(route = "login")
        object Registration : Unauthenticated(route = "registration")
    }

    // Authenticated Routes
    sealed class Authenticated(val route: String) : NavigationRoutes() {
        object NavigationRoute : Authenticated(route = "authenticated")
        object Dashboard : Authenticated(route = "Dashboard")
        object DetailsScreen : Authenticated(route = "DetailsScreen")
    }

    // SplashScreen Routes
    sealed class RegisterSplashScreen(val route: String) : NavigationRoutes() {
        object SplashScreen : RegisterSplashScreen(route = "SplashScreen")
    }
}