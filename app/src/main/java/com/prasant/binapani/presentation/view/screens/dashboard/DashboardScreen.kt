package com.prasant.binapani.presentation.view.screens.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun DashboardScreen(onNavigateController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconNavigationButton("Go to Screen 1", Icons.Default.Home) { onNavigateController.navigate("screen1") }
        IconNavigationButton("Go to Screen 2", Icons.Default.Person) { onNavigateController.navigate("screen2") }
        IconNavigationButton("Go to Screen 3", Icons.Default.Settings) { onNavigateController.navigate("screen3") }
        IconNavigationButton("Go to Screen 4", Icons.Default.Info) { onNavigateController.navigate("screen4") }
    }
}

@Composable
fun IconNavigationButton(text: String, icon: ImageVector, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        contentPadding = PaddingValues(12.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text)
    }
}

@Composable
fun ScreenContent(title: String, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Go Back")
        }
    }
}

@Composable
fun ButtonNavigationWithIconsApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { DashboardScreen(navController) }
        composable("screen1") { ScreenContent("Screen 1", navController) }
        composable("screen2") { ScreenContent("Screen 2", navController) }
        composable("screen3") { ScreenContent("Screen 3", navController) }
        composable("screen4") { ScreenContent("Screen 4", navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonNavigationWithIconsApp() {
    ButtonNavigationWithIconsApp()
}