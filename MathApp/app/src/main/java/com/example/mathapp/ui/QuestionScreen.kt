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
fun QuestionScreen(navController: NavController, viewModel: MathGameViewModel = viewModel()) {
    val currentIndex = viewModel.currentQuestionIndex.value
    val numQuestions = viewModel.numQuestions.value

    // Ensure the currentIndex is within bounds of the questions list
    if (currentIndex < viewModel.questions.size) {
        val (a, b) = viewModel.questions[currentIndex]
        var userAnswer by remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Question: $a + $b = ?")

            OutlinedTextField(
                value = userAnswer,
                onValueChange = { userAnswer = it },
                label = { Text("Your answer") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                // Check the answer, and if the question is correct, move to the next question
                viewModel.checkAnswer(userAnswer.toIntOrNull() ?: -1)
                userAnswer = ""

                // Navigate to the result screen when all questions are answered
                if (currentIndex >= numQuestions - 1) {
                    navController.navigate("result") {
                        // Clear the navigation stack so the user can't go back to the question screen
                        popUpTo("question") { inclusive = true }
                    }
                }
            }) {
                Text("Next")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                // Navigate back to the start screen
                navController.navigate("start") {
                    // Clear the navigation stack to restart the game
                    popUpTo("start") { inclusive = true }
                }
            }) {
                Text("Cancel")
            }
        }
    } else {
        // Handle case where questions list is empty or there's an issue with the data
        Text("Error: No questions available.")
    }
}
