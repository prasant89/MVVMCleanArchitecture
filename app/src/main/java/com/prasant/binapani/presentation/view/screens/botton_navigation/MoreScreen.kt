package com.prasant.binapani.presentation.view.screens.botton_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun  MoreScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "More Options",
            style = MaterialTheme.typography.h4.copy(fontSize = 24.sp),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Option Card 1 - Profile
        OptionCard(
            icon = Icons.Filled.AccountCircle,
            title = "Profile",
            description = "Manage your profile details",
            onClick = { /* Navigate to Profile */ }
        )

        // Option Card 2 - Settings
        OptionCard(
            icon = Icons.Filled.Settings,
            title = "Settings",
            description = "Adjust your app settings",
            onClick = { /* Navigate to Settings */ }
        )

        // Option Card 3 - About
        OptionCard(
            icon = Icons.Filled.Info,
            title = "About",
            description = "Learn more about this app",
            onClick = { /* Navigate to About */ }
        )
    }
}

@Composable
fun OptionCard(icon: ImageVector, title: String, description: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = MaterialTheme.colors.primary
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, style = MaterialTheme.typography.h6)
                Text(text = description, style = MaterialTheme.typography.body2)
            }
        }
    }
}