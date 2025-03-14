package com.example.mathapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mathapp.ui.QuestionScreen
import com.example.mathapp.ui.ResultScreen
import com.example.mathapp.ui.StartScreen
import com.example.mathapp.ui.viewmodel.MathGameViewModel
import com.example.mathapp.ui.theme.MathAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MathAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MathApp()
                }
            }
        }
    }
}

@Composable
fun MathApp() {
    val navController = rememberNavController()
    val viewModel: MathGameViewModel = viewModel()

    NavHost(navController = navController, startDestination = "start") {
        composable("start") {
            StartScreen(navController, viewModel)
        }
        composable("question") {
            QuestionScreen(navController, viewModel)
        }
        composable("result") {
            ResultScreen(navController, viewModel)
        }
    }
}
