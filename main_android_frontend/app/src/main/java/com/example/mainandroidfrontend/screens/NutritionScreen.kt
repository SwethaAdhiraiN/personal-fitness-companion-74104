package com.example.mainandroidfrontend.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mainandroidfrontend.viewmodel.NutritionViewModel
import com.example.mainandroidfrontend.viewmodel.CalorieViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NutritionScreen(
    navController: NavController,
    nutritionViewModel: NutritionViewModel = viewModel(),
    calorieViewModel: CalorieViewModel = viewModel()
) {
    var dailyCalories by remember { mutableStateOf("") }
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(26.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Nutrition Suggestions", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(18.dp))
            OutlinedTextField(
                value = dailyCalories,
                onValueChange = { dailyCalories = it },
                label = { Text("Enter your daily calorie target") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    val cals = dailyCalories.toDoubleOrNull()
                    nutritionViewModel.generateMealPlan(cals)
                },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Get Meal Plan") }
            Spacer(modifier = Modifier.height(18.dp))
            nutritionViewModel.mealPlan.takeIf { it.isNotEmpty() }?.let { plan ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary.copy(alpha=0.11f))
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Sample Meal Plan:", style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(10.dp))
                        for (meal in plan) {
                            Text("${meal.meal}: ${meal.calories} kcal")
                        }
                    }
                }
            }
        }
    }
}
