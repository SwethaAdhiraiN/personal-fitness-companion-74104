package com.example.mainandroidfrontend.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mainandroidfrontend.screens.*

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Onboarding.route,
        modifier = modifier,
    ) {
        composable(Screen.Onboarding.route) { OnboardingScreen(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Register.route) { RegisterScreen(navController) }
        composable(Screen.ProfileInput.route) { ProfileInputScreen(navController) }
        composable(Screen.Dashboard.route) { DashboardScreen(navController) }
        composable(Screen.BMICalc.route) { BmiCalculatorScreen(navController) }
        composable(Screen.CalorieCalc.route) { CalorieCalcScreen(navController) }
        composable(Screen.Nutrition.route) { NutritionScreen(navController) }
        composable(Screen.Workout.route) { WorkoutScreen(navController) }
        composable(Screen.ExerciseDemo.route) { ExerciseDemoScreen(navController) }
        composable(Screen.ProgressTracker.route) { ProgressTrackerScreen(navController) }
        composable(Screen.TrainerCounsel.route) { TrainerCounselScreen(navController) }
        composable(Screen.Payment.route) { PaymentScreen(navController) }
    }
}

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object Register : Screen("register")
    object ProfileInput : Screen("profile_input")
    object Dashboard : Screen("dashboard")
    object BMICalc : Screen("bmi_calc")
    object CalorieCalc : Screen("calorie_calc")
    object Nutrition : Screen("nutrition")
    object Workout : Screen("workout")
    object ExerciseDemo : Screen("exercise_demo")
    object ProgressTracker : Screen("progress_tracker")
    object TrainerCounsel : Screen("trainer_counsel")
    object Payment : Screen("payment")
}
