package com.prasant.binapani.presentation.view.screens.botton_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prasant.binapani.R

@Composable
fun  SchoolHomePage(navController: NavController) {
    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { HeaderSection() }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { QuickActionsSection() }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { AnnouncementsSection() }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { EventsSection() }
        }
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.binapani_logo),
                contentDescription = "School Logo",
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.White, CircleShape)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Wel Come Binapani High School",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun QuickActionsSection() {
    Column {
        Text(
            text = "Quick Actions",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            QuickActionItem("Attendance", R.drawable.ic_attendance)
            QuickActionItem("Timetable", R.drawable.ic_calendar)
            QuickActionItem("Notifications", R.drawable.ic_notification_bell)
            QuickActionItem("Homework", R.drawable.ic_child)
        }
    }
}

@Composable
fun QuickActionItem(title: String, iconRes: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = title,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .size(48.dp)
                .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.2f), CircleShape)
                .padding(12.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = title, fontSize = 12.sp)
    }
}

@Composable
fun AnnouncementsSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Announcements",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text("📢 New Sports Day event announced!", style = MaterialTheme.typography.bodyMedium)
        Text("📢 Parent-teacher meeting scheduled.", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun EventsSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Upcoming Events",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text("🎉 Science Exhibition - March 25", style = MaterialTheme.typography.bodyMedium)
        Text("🎓 Graduation Ceremony - April 15", style = MaterialTheme.typography.bodyMedium)
    }
}
