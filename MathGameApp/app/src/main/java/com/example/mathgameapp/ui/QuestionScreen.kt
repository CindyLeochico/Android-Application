package com.example.mathgameapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mathgameapp.ui.viewmodel.MathGameViewModel

@Composable
fun QuestionScreen(navController: NavController, viewModel: MathGameViewModel = viewModel()) {
    val currentIndex = viewModel.currentQuestionIndex.value
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
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.checkAnswer(userAnswer.toIntOrNull() ?: -1)
            if (currentIndex >= viewModel.numQuestions.value - 1) {
                navController.navigate("result")
            }
            userAnswer = ""
        }) {
            Text("Next")
        }

        Button(onClick = { navController.navigate("start") }) {
            Text("Cancel")
        }
    }
}
