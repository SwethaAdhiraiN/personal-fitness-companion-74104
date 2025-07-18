package com.example.mainandroidfrontend.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// PUBLIC_INTERFACE
class CalorieViewModel : ViewModel() {
    var weight by mutableStateOf("")
    var height by mutableStateOf("")
    var age by mutableStateOf("")
    var gender by mutableStateOf("Male")
    var activityLevelIndex by mutableStateOf(0)
    var calorieResult by mutableStateOf<Double?>(null)

    val activityLevels = listOf(
        "Sedentary (little or no exercise)" to 1.2,
        "Lightly active (1-3 days/week)" to 1.375,
        "Moderately active (3-5 days/week)" to 1.55,
        "Very active (6-7 days/week)" to 1.725,
        "Super active (hard exercise, physical job)" to 1.9
    )

    // PUBLIC_INTERFACE
    fun calculateCalories() {
        val w = weight.toDoubleOrNull()
        val h = height.toDoubleOrNull()
        val a = age.toDoubleOrNull()
        if (w != null && h != null && a != null) {
            val bmr = if (gender == "Male")
                10 * w + 6.25 * h - 5 * a + 5
            else
                10 * w + 6.25 * h - 5 * a - 161

            val activityFactor = activityLevels.getOrNull(activityLevelIndex)?.second ?: 1.2
            calorieResult = bmr * activityFactor
        } else {
            calorieResult = null
        }
    }
}
