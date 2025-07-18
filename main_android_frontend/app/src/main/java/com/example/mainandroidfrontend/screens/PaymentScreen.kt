package com.example.mainandroidfrontend.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.mainandroidfrontend.navigation.Screen

@Composable
fun PaymentScreen(navController: NavController) {
    var paid by remember { mutableStateOf(false) }
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Payment", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(32.dp))
            if(!paid) {
                Text("Pay \$30 for your trainer session!", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = { paid = true; navController.navigate(Screen.Dashboard.route) },
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Pay") }
            } else {
                Text("Payment successful!", color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}
