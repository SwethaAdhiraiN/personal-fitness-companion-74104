package com.example.mainandroidfrontend.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mainandroidfrontend.viewmodel.CalorieViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CalorieCalcScreen(
    navController: NavController,
    calorieViewModel: CalorieViewModel = viewModel()
) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Calorie Requirement", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = calorieViewModel.height,
                onValueChange = { calorieViewModel.height = it },
                label = { Text("Height (cm)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = calorieViewModel.weight,
                onValueChange = { calorieViewModel.weight = it },
                label = { Text("Weight (kg)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(6.dp))
            OutlinedTextField(
                value = calorieViewModel.age,
                onValueChange = { calorieViewModel.age = it },
                label = { Text("Age") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Gender:")
                Spacer(modifier = Modifier.width(10.dp))
                DropdownMenuBox(
                    selectedOption = calorieViewModel.gender,
                    options = listOf("Male", "Female"),
                    onOptionSelected = { calorieViewModel.gender = it }
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Activity Level:")
                Spacer(modifier = Modifier.width(10.dp))
                DropdownMenuBox(
                    selectedOption = calorieViewModel.activityLevels[calorieViewModel.activityLevelIndex].first,
                    options = calorieViewModel.activityLevels.map { it.first },
                    onOptionSelected = {
                        val index = calorieViewModel.activityLevels.indexOfFirst { lvl -> lvl.first == it }
                        calorieViewModel.activityLevelIndex = if (index != -1) index else 0
                    }
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            Button(
                onClick = { calorieViewModel.calculateCalories() },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Calculate") }
            Spacer(modifier = Modifier.height(16.dp))
            calorieViewModel.calorieResult?.let {
                Text("Daily Requirement: ${it.toInt()} kcal", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}

@Composable
fun DropdownMenuBox(selectedOption: String, options: List<String>, onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Box {
        OutlinedButton(onClick={ expanded = true }) {
            Text(selectedOption)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach {
                DropdownMenuItem(
                    text = { Text(it) },
                    onClick = { onOptionSelected(it); expanded = false }
                )
            }
        }
    }
}
