package com.example.birthdaycardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.birthdaycardapp.ui.theme.BirthdayCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BirthdayCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingText(
                        message = "Happy Birthday Cici!",
                        from = "From: Ate Chacha",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize() // Fill the whole screen
            .padding(16.dp)
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.image), // Replace with your image resource
            contentDescription = "Birthday Image",
            contentScale = ContentScale.Crop, // Ensures the image covers the entire area
            modifier = Modifier.fillMaxSize() // Fills the whole background
        )

        // Centered text on top of the background image
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize() // Takes up the whole space
        ) {
            Text(
                text = message,
                fontSize = 100.sp,
                lineHeight = 116.sp,
                textAlign = TextAlign.Center,
                color = Color.White // White text for contrast
            )
            Spacer(modifier = Modifier.height(16.dp)) // Space between message and "from" text
            Text(
                text = from,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                color = Color.White // White text for contrast
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BirthdayCardAppTheme {
        GreetingText("Happy Birthday Cindy!", "From Lily")
    }
}
