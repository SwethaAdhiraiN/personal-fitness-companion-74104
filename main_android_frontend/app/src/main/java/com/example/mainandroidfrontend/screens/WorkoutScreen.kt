package com.example.mainandroidfrontend.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mainandroidfrontend.viewmodel.WorkoutViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mainandroidfrontend.navigation.Screen

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun WorkoutScreen(
    navController: NavController,
    workoutViewModel: WorkoutViewModel = viewModel()
) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(26.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Workout Planner", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(12.dp))
            LevelSegmentedButton(
                selectedLevel = workoutViewModel.selectedLevel,
                levels = workoutViewModel.levels,
                onLevelSelected = { workoutViewModel.selectedLevel = it }
            )
            Spacer(modifier = Modifier.height(14.dp))
            LazyColumn(
                modifier = Modifier.weight(1f).fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(workoutViewModel.workouts.size) { idx ->
                    val workout = workoutViewModel.workouts[idx]
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(horizontal=6.dp),
                        onClick = { navController.navigate(Screen.ExerciseDemo.route) }
                    ) {
                        Column(Modifier.padding(12.dp)) {
                            Text(workout.name, style = MaterialTheme.typography.titleMedium)
                            Text(workout.description, style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LevelSegmentedButton(
    selectedLevel: String,
    levels: List<String>,
    onLevelSelected: (String) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        levels.forEach { level ->
            val selected = selectedLevel == level
            Button(
                onClick = { onLevelSelected(level) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text(level, color = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.primary)
            }
            Spacer(modifier = Modifier.width(6.dp))
        }
    }
}
