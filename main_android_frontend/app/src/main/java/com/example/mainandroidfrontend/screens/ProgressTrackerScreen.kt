package com.example.mainandroidfrontend.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mainandroidfrontend.viewmodel.ProgressViewModel
import androidx.compose.ui.Alignment

@Composable
fun ProgressTrackerScreen(
    navController: NavController,
    progressViewModel: ProgressViewModel = viewModel()
) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Progress Tracker", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(14.dp))
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(progressViewModel.progress.size) { idx ->
                    val item = progressViewModel.progress[idx]
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(Modifier.padding(16.dp)) {
                            Text(item.exercise, style = MaterialTheme.typography.titleMedium)
                            Text("Weight: ${item.lastWeight} kg, Reps: ${item.lastReps}")
                        }
                    }
                }
            }
        }
    }
}
