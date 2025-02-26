package com.example.counterapp;
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterApp()
        }
    }
}

@Composable
fun CounterApp() {
    var count by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA)), // Light gray background
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$count",
            fontSize = 350.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E88E5) // Blue text
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Button(
                onClick = { count++ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)), // Green
                modifier = Modifier
                    .padding(8.dp)
                    .size(120.dp, 50.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Add", fontSize = 18.sp, color = Color.White)
            }

            Button(
                onClick = { if (count > 0) count-- },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)), // Red
                modifier = Modifier
                    .padding(8.dp)
                    .size(120.dp, 50.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Minus", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterAppPreview() {
    CounterApp()
}
