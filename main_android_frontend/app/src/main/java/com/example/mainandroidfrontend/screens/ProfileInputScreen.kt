package com.example.mainandroidfrontend.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mainandroidfrontend.navigation.Screen
import com.example.mainandroidfrontend.viewmodel.ProfileViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.mainandroidfrontend.ui.ProfileImage

@Composable
fun ProfileInputScreen(
    navController: NavController,
    profileViewModel: ProfileViewModel = viewModel()
) {
    var error by remember { mutableStateOf("") }
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Show the profile picture at the top
            ProfileImage()
            Spacer(modifier = Modifier.height(16.dp))
            Text("Profile", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = profileViewModel.name,
                onValueChange = { profileViewModel.name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = profileViewModel.age,
                onValueChange = { profileViewModel.age = it },
                label = { Text("Age") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = profileViewModel.gender,
                onValueChange = { profileViewModel.gender = it },
                label = { Text("Gender (Male/Female)" ) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = profileViewModel.height,
                onValueChange = { profileViewModel.height = it },
                label = { Text("Height (cm)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = profileViewModel.weight,
                onValueChange = { profileViewModel.weight = it },
                label = { Text("Weight (kg)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = profileViewModel.goalWeight,
                onValueChange = { profileViewModel.goalWeight = it },
                label = { Text("Goal Weight (kg)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = profileViewModel.activityLevel,
                onValueChange = { profileViewModel.activityLevel = it },
                label = { Text("Activity Level (e.g. Light/Mod/Heavy)") },
                modifier = Modifier.fillMaxWidth()
            )
            if (error.isNotEmpty()) {
                Text(error, color = MaterialTheme.colorScheme.error)
            }
            Spacer(modifier = Modifier.height(18.dp))
            Button(
                onClick = {
                    if(profileViewModel.name.isBlank() || profileViewModel.height.isBlank() || profileViewModel.weight.isBlank()) {
                        error = "Fill all required fields"
                    } else {
                        navController.navigate(Screen.Dashboard.route)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Save & Continue") }
        }
    }
}
