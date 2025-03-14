package com.example.mathapp.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MathGameViewModel : ViewModel() {
    var currentQuestionIndex = mutableStateOf(0) // Use mutableStateOf for primitive types
    var correctAnswers = mutableStateOf(0)
    var wrongAnswers = mutableStateOf(0)
    var numQuestions = mutableStateOf(5)
    val questions = mutableListOf<Pair<Int, Int>>()

    // Function to set the number of questions and generate the questions
    fun setNumQuestions(count: Int) {
        numQuestions.value = count // Use value instead of intValue
        generateQuestions()
    }

    // Function to generate random addition questions
    private fun generateQuestions() {
        questions.clear()
        repeat(numQuestions.value) {  // Ensure the number of questions matches the input
            val a = Random.nextInt(1, 10)
            val b = Random.nextInt(1, 10)
            questions.add(a to b)
        }
    }


    // Function to check the user's answer and update the score
    fun checkAnswer(answer: Int) {
        // Check if we are still within bounds of the questions list
        if (currentQuestionIndex.value < questions.size) {
            val (a, b) = questions[currentQuestionIndex.value]
            if (a + b == answer) correctAnswers.value++ else wrongAnswers.value++
        }
        currentQuestionIndex.value++

        // Check if all questions have been answered
        if (currentQuestionIndex.value >= numQuestions.value) {
            // If the last question is answered, navigate to the result screen
            // Trigger navigation to the result screen here
        }
    }



    // Function to reset the game
    fun resetGame() {
        currentQuestionIndex.value = 0
        correctAnswers.value = 0
        wrongAnswers.value = 0
        generateQuestions()
    }
}
