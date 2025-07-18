package com.example.mainandroidfrontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mainandroidfrontend.ui.theme.PersonalFitnessTheme
import com.example.mainandroidfrontend.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonalFitnessTheme {
                FitnessApp()
            }
        }
    }
}

@Composable
fun FitnessApp() {
    val navController = rememberNavController()
    AppNavHost(navController = navController)
}
