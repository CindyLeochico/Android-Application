package com.example.mathapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mathapp.ui.viewmodel.MathGameViewModel

@Composable
fun ResultScreen(navController: NavController, viewModel: MathGameViewModel = viewModel()) {
    // Use .value to access the current state
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Game Over!")
        Text("Correct: ${viewModel.correctAnswers.value}")
        Text("Wrong: ${viewModel.wrongAnswers.value}")

        Button(onClick = {
            viewModel.resetGame()  // Reset the game state
            navController.navigate("start")  // Navigate back to the start screen
        }) {
            Text("Play Again")
        }
    }
}
