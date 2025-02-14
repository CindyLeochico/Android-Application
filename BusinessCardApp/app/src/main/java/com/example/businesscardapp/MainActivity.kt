package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                BusinessCard()
            }
        }
    }
}

@Composable
fun BusinessCard() {
    val BackgroundColor = Color(0xFFE6E6FA)
    val MainTextColor = Color(0xFF4B0082)
    val SubtitleColor = Color(0xFF9932CC)


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(BackgroundColor)


    ) {
        Spacer(modifier = Modifier.height(160.dp))
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 16.dp)
        )

        Text(
            text = "Cindy April D. Leochico",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MainTextColor
        )

        Text(
            text = "Web | Android Developer",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 32.dp),
            color = SubtitleColor
        )

        Spacer(modifier = Modifier.height(180.dp))
        ContactRow(icon = Icons.Default.Phone, contactText = "+1 (587) 971 0430")
        ContactRow(icon = Icons.Default.Person, contactText = "@CindyAprilLeochico")
        ContactRow(icon = Icons.Default.Email, contactText = "dakisleochico@gmail.com")

    }
}

@Composable
fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, contactText: String) {
    val IconColor = Color(0xFF4B0082)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width(18.dp))
        Text(text = contactText, fontSize = 14.sp,  color = IconColor)

    }
}
@Preview(showBackground = true)
@Composable
fun PreviewBusinessCard() {
    BusinessCardAppTheme {
        BusinessCard()
    }
}
