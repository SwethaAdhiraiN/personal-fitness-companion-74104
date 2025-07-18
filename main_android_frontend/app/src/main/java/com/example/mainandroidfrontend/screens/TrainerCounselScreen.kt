package com.example.mainandroidfrontend.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mainandroidfrontend.navigation.Screen

@Composable
fun TrainerCounselScreen(navController: NavController) {
    var booked by remember { mutableStateOf(false) }
    var paid by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }
    var chatHistory by remember { mutableStateOf(listOf<String>()) }

    Surface(modifier= Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background)
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Trainer Counseling", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(18.dp))
            if (!booked) {
                Button(
                    onClick = { booked = true },
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Book Counseling Session") }
            } else if (!paid) {
                Text("Session booked!", color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = { paid = true },
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Pay Now (Mock)") }
            } else {
                Text("Session paid. Chat with your trainer below!", color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(12.dp))
                // Mock chat box
                Column(
                    modifier = Modifier
                        .weight(1f, fill = false)
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    chatHistory.forEach {
                        Card(modifier = Modifier.fillMaxWidth().padding(vertical=2.dp)) {
                            Text(it, modifier = Modifier.padding(10.dp))
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = message,
                        onValueChange = { message = it },
                        placeholder = { Text("Type a message...") },
                        modifier = Modifier.weight(1f)
                    )
                    Button(
                        onClick = {
                            if (message.isNotBlank()) {
                                chatHistory = chatHistory + "You: $message"
                                message = ""
                                // Simulate trainer response
                                chatHistory = chatHistory + "Trainer: Stay consistent and track your progress!"
                            }
                        }
                    ) { Text("Send") }
                }
            }
        }
    }
}
