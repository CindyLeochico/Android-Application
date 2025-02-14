package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtTopAppBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFFE6E6FA)
        ),
        title = {
            Text(
                text = stringResource(R.string.app_name),
                color = Color(0xFF4B0082),
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
        }
    )
}

@Composable
fun ArtSpaceApp() {
    val backgroundColor = Color(0xFFE6E6FA) // Light Purple
    val mainTextColor = Color(0xFF4B0082)  // Indigo
    val subtitleColor = Color(0xFF9932CC)  // Purple

    val artworks = listOf(
        Artwork(R.drawable.image1, "Starry Night", "Vincent van Gogh"),
        Artwork(R.drawable.image2, "Mona Lisa", "Leonardo da Vinci"),
        Artwork(R.drawable.image3, "The Persistence of Memory", "Salvador Dalí")
    )

    var currentIndex by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize().background(backgroundColor),
        topBar = {
            ArtTopAppBar()
        }
    ) { paddingValues -> // ✅ Fix: Correct syntax
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(paddingValues), // ✅ Fix: Prevents overlap with AppBar
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top // ✅ Fix: Removed extra comma
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Image(
                painter = painterResource(id = artworks[currentIndex].imageRes),
                contentDescription = "Artwork",
                modifier = Modifier.size(300.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = artworks[currentIndex].title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = mainTextColor
            )
            Text(
                text = "by ${artworks[currentIndex].artist}",
                fontSize = 18.sp,
                color = subtitleColor
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row {
                Button(
                    onClick = { currentIndex = (currentIndex - 1 + artworks.size) % artworks.size },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Previous")
                }

                Button(
                    onClick = { currentIndex = (currentIndex + 1) % artworks.size },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Next")
                }
            }
        }
    }
}

data class Artwork(val imageRes: Int, val title: String, val artist: String)
