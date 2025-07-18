package com.example.mainandroidfrontend.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mainandroidfrontend.viewmodel.BmiViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.mainandroidfrontend.ui.AppBackground

@Composable
fun BmiCalculatorScreen(
    navController: NavController,
    bmiViewModel: BmiViewModel = viewModel()
) {
    AppBackground {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("BMI Calculator", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onPrimary)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = bmiViewModel.heightCm,
                onValueChange = { bmiViewModel.heightCm = it },
                label = { Text("Height (cm)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = bmiViewModel.weightKg,
                onValueChange = { bmiViewModel.weightKg = it },
                label = { Text("Weight (kg)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(18.dp))
            Button(
                onClick = { bmiViewModel.calculateBmi() },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Calculate BMI") }
            Spacer(modifier = Modifier.height(18.dp))
            bmiViewModel.bmiResult?.let {
                Text("Your BMI: %.1f (%s)".format(it, bmiViewModel.bmiCategory),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.headlineSmall)
            }
        }
    }
}
