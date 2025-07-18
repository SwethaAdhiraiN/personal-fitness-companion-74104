package com.example.mainandroidfrontend.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mainandroidfrontend.navigation.Screen

@Composable
fun DashboardScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Dashboard", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DashTile("BMI", Icons.Filled.Favorite, { navController.navigate(Screen.BMICalc.route) }, modifier = Modifier.weight(1f))
                DashTile("Calories", Icons.Filled.LocalFireDepartment, { navController.navigate(Screen.CalorieCalc.route) }, modifier = Modifier.weight(1f))
                DashTile("Nutrition", Icons.Filled.Restaurant, { navController.navigate(Screen.Nutrition.route) }, modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DashTile("Workouts", Icons.Filled.FitnessCenter, { navController.navigate(Screen.Workout.route) }, modifier = Modifier.weight(1f))
                DashTile("Progress", Icons.Filled.ShowChart, { navController.navigate(Screen.ProgressTracker.route) }, modifier = Modifier.weight(1f))
                DashTile("Trainer", Icons.Filled.Person, { navController.navigate(Screen.TrainerCounsel.route) }, modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun DashTile(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .aspectRatio(1f)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.1f)
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(icon, contentDescription = title, modifier = Modifier.size(40.dp), tint = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.height(10.dp))
            Text(title, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
