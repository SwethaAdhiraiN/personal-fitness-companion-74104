package com.example.mainandroidfrontend.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class Workout(
    val name: String,
    val level: String,
    val description: String
)

// PUBLIC_INTERFACE
class WorkoutViewModel : ViewModel() {
    var selectedLevel by mutableStateOf("Beginner")
    val levels = listOf("Beginner", "Intermediate", "Expert")
    val workouts get() = when(selectedLevel) {
        "Beginner" -> listOf(
            Workout("Full Body Basics", "Beginner", "Simple squat, push-up, plank bodyweight circuit."),
            Workout("Cardio Starter", "Beginner", "Light jog and brisk walk cycles.")
        )
        "Intermediate" -> listOf(
            Workout("Strength Builder", "Intermediate", "Dumbbell circuits, challenging variations."),
            Workout("HIIT Intro", "Intermediate", "Burpees, high knees, light weights.")
        )
        else -> listOf(
            Workout("Athlete Routine", "Expert", "Olympic lifts, plyo push-ups, advanced HIIT."),
            Workout("Endurance Pro", "Expert", "Long run, rope skipping, box jumps.")
        )
    }
}
