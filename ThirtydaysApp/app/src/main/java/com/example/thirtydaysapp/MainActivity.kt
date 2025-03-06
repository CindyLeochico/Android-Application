package com.example.thirtydaysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaysapp.data.Datasource
import com.example.thirtydaysapp.model.Tip
import com.example.thirtydaysapp.ui.theme.AffirmationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AffirmationAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Title()
                        Spacer(modifier = Modifier.height(16.dp))
                        ThirtyDaysApp()
                    }
                }
            }
        }
    }
}

@Composable
fun Title() {

    val titleOffsetY by animateDpAsState(
        targetValue = 0.dp,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
    )
    val titleAlpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
    )

    Text(
        text = "30 Days Tips",
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .offset(y = titleOffsetY)
            .alpha(titleAlpha)
    )
}

@Composable
fun ThirtyDaysApp() {
    TipList(tipList = Datasource().loadTips())
}

@Composable
fun TipCard(tip: Tip, modifier: Modifier = Modifier) {

    val cardAlpha by animateFloatAsState(targetValue = 1f,
        animationSpec = tween(durationMillis = 500))
    val cardScale by animateFloatAsState(targetValue = 1.05f,
        animationSpec = tween(durationMillis = 500))


    val textOffsetY by animateDpAsState(targetValue = 0.dp,
        animationSpec = tween(durationMillis = 500))

    val imageAlpha by animateFloatAsState(targetValue = 1f,
        animationSpec = tween(durationMillis = 700))

    Card(
        modifier = modifier
            .graphicsLayer(
                scaleX = cardScale,
                scaleY = cardScale
            )
            .alpha(cardAlpha)
    ) {
        Column {
            AnimatedVisibility(
                visible = true,
                enter = slideInVertically(initialOffsetY = { it }) + fadeIn(),
                exit = slideOutVertically(targetOffsetY = { it }) + fadeOut()
            ) {
                Image(
                    painter = painterResource(tip.imageResourceId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(194.dp)
                        .alpha(imageAlpha),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = stringResource(tip.stringResourcesId),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(16.dp)
                    .offset(y = textOffsetY)
            )
        }
    }
}

@Composable
fun TipList(tipList: List<Tip>) {
    LazyColumn() {
        items(items = tipList) { tip ->
            TipCard(
                tip = tip,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AffirmationAppTheme {
        ThirtyDaysApp()
    }
}
