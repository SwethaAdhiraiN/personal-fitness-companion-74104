package com.example.mainandroidfrontend.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class WorkoutProgress(
    val exercise: String,
    val lastWeight: Int,
    val lastReps: Int
)

// PUBLIC_INTERFACE
class ProgressViewModel : ViewModel() {
    var progress by mutableStateOf(listOf(
        WorkoutProgress("Squat", 40, 10),
        WorkoutProgress("Push-Up", 0, 15),
        WorkoutProgress("Deadlift", 60, 5)
    ))

    fun addProgress(item: WorkoutProgress) {
        progress = progress + item
    }
}
