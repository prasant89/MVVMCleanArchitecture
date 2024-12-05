package com.prasant.binapani.presentation.navigation

object NavigationRoutes {
    object SplashScreen {
        const val route = "SplashScreen"
    }

    object Unauthenticated {
        object NavigationRoute {
            const val route = "unauthenticated"
        }

        object Login {
            const val route = "loginPage"
        }

        object Registration {
            const val route = "registrationPage"
        }
    }

    object Authenticated {
        object NavigationRoute {
            const val route = "authenticated"
        }

        object Dashboard {
            const val route = "dashboardPage"
        }
    }
}