package com.example.mathgameapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mathgameapp.ui.viewmodel.MathGameViewModel

@Composable
fun ResultScreen(navController: NavController, viewModel: MathGameViewModel = viewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Game Over!")
        Text("Correct: ${viewModel.correctAnswers.value}")
        Text("Wrong: ${viewModel.wrongAnswers.value}")

        Button(onClick = {
            viewModel.resetGame()
            navController.navigate("start")
        }) {
            Text("Play Again")
        }
    }
}
