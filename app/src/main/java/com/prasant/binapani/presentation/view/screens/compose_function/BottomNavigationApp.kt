package com.prasant.binapani.presentation.view.screens.compose_function

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.prasant.binapani.presentation.view.screens.botton_navigation.Home
import com.prasant.binapani.presentation.view.screens.botton_navigation.More
import com.prasant.binapani.presentation.view.screens.botton_navigation.Profile
import com.prasant.binapani.presentation.view.screens.botton_navigation.Setting

@Composable
fun BottomNavigationApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "screen1",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("screen1") { Home(navController) }
            composable("screen2") { Profile(navController) }
            composable("screen3") { Setting(navController) }
            composable("screen4") { More(navController) }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Home", Icons.Default.Home, "screen1"),
        BottomNavItem("Person", Icons.Default.Person, "screen2"),
        BottomNavItem("Setting", Icons.Default.Settings, "screen3"),
        BottomNavItem("More", Icons.Default.Info, "screen4")
    )

    BottomNavigation {
        val currentBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStackEntry.value?.destination

        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.title) },
                selected = currentDestination?.route == item.route,
                onClick = { navController.navigate(item.route) }
            )
        }
    }
}

data class BottomNavItem(val title: String, val icon: ImageVector, val route: String)

@Preview(showBackground = true)
@Composable
fun PreviewBottomNavigationApp() {
    BottomNavigationApp()
}
