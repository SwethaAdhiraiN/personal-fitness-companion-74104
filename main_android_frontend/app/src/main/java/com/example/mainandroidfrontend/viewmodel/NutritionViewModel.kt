package com.example.mainandroidfrontend.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class MealSuggestion(val meal: String, val calories: Int)

// PUBLIC_INTERFACE
class NutritionViewModel : ViewModel() {
    var mealPlan by mutableStateOf(listOf<MealSuggestion>())

    // PUBLIC_INTERFACE
    fun generateMealPlan(calorieTarget: Double?) {
        // Mock: Just some pre-defined meals
        mealPlan = if (calorieTarget != null && calorieTarget > 0) {
            listOf(
                MealSuggestion("Breakfast: Oatmeal + Banana", 350),
                MealSuggestion("Lunch: Grilled Chicken, Quinoa, Broccoli", 500),
                MealSuggestion("Snack: Greek Yogurt", 150),
                MealSuggestion("Dinner: Salmon, Brown Rice, Spinach", 600)
            )
        } else emptyList()
    }
}
