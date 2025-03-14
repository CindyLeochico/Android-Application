package com.example.mathgameapp.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MathGameViewModel : ViewModel() {
    var currentQuestionIndex = mutableStateOf(0)
    var correctAnswers = mutableStateOf(0)
    var wrongAnswers = mutableStateOf(0)
    var numQuestions = mutableStateOf(5)
    val questions = mutableListOf<Pair<Int, Int>>()

    fun setNumQuestions(count: Int) {
        numQuestions.value = count
        generateQuestions()
    }

    private fun generateQuestions() {
        questions.clear()
        repeat(numQuestions.value) {
            val a = Random.nextInt(1, 10)
            val b = Random.nextInt(1, 10)
            questions.add(a to b)
        }
    }

    fun checkAnswer(answer: Int) {
        val (a, b) = questions[currentQuestionIndex.value]
        if (a + b == answer) correctAnswers.value++ else wrongAnswers.value++
        currentQuestionIndex.value++
    }

    fun resetGame() {
        currentQuestionIndex.value = 0
        correctAnswers.value = 0
        wrongAnswers.value = 0
        generateQuestions()
    }
}
