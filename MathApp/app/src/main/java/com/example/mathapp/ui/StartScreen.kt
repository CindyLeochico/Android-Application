package com.example.mathapp.ui


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mathapp.ui.viewmodel.MathGameViewModel

@Composable
fun StartScreen(navController: NavController, viewModel: MathGameViewModel = viewModel()) {
    var numQuestions by remember { mutableStateOf("5") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Math Game", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = numQuestions,
            onValueChange = { numQuestions = it },
            label = { Text("Enter number of questions") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.setNumQuestions(numQuestions.toIntOrNull() ?: 5)
            navController.navigate("question")
        }) {
            Text("Start")
        }
    }
}
