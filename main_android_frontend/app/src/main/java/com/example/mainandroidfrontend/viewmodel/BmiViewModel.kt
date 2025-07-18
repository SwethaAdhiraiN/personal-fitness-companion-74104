package com.example.mainandroidfrontend.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// PUBLIC_INTERFACE
class BmiViewModel : ViewModel() {
    /** Stores user input values for BMI calculation. */
    var heightCm by mutableStateOf("")
    var weightKg by mutableStateOf("")
    var bmiResult by mutableStateOf<Double?>(null)
    var bmiCategory by mutableStateOf("")

    // PUBLIC_INTERFACE
    fun calculateBmi() {
        val height = heightCm.toDoubleOrNull()
        val weight = weightKg.toDoubleOrNull()
        if(height != null && weight != null && height > 0.0) {
            val bmi = weight / ((height / 100) * (height / 100))
            bmiResult = String.format("%.1f", bmi).toDouble()
            bmiCategory = when {
                bmi < 18.5 -> "Underweight"
                bmi < 24.9 -> "Normal"
                bmi < 29.9 -> "Overweight"
                else -> "Obese"
            }
        } else {
            bmiResult = null
            bmiCategory = ""
        }
    }
}
