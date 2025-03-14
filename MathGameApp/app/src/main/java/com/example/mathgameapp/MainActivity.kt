package com.example.mathgameapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mathgameapp.ui.QuestionScreen
import com.example.mathgameapp.ui.ResultScreen
import com.example.mathgameapp.ui.StartScreen
import com.example.mathgameapp.ui.viewmodel.MathGameViewModel
import com.example.mathgameapp.ui.theme.MathGameAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MathGameAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MathGameApp()
                }
            }
        }
    }
}

@Composable
fun MathGameApp() {
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
