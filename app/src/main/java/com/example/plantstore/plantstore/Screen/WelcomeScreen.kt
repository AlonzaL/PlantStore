package com.example.plantstore.plantstore.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantstore.R
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen() {
    val images = listOf(
        R.drawable.flower_1,
        R.drawable.flower_2,
        R.drawable.flower_1,
        R.drawable.flower_2,
    )

    var currentIndex by remember { mutableIntStateOf(0) }

    // Автоматическое переключение
    LaunchedEffect(currentIndex, images.size) {
        // Каждый раз, когда currentIndex меняется, запускается новый LaunchedEffect
        delay(2500)
        currentIndex = (currentIndex + 1) % images.size
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 42.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.bg_welcomescreen),
            contentDescription = "bk",
            modifier = Modifier
                .size(670.dp)
                .padding(top = 42.dp)
            ,
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Skip",
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 75.dp, end = 40.dp)
            )

            // Картинка
            Image(
                painter = painterResource(id = images[currentIndex]),
                contentDescription = "",
                modifier = Modifier
                    .size(470.dp, 500.dp)
            )

            Spacer(modifier = Modifier.padding(bottom = 10.dp))

            Text(
                text = "Surround yourself with\nthese decorative plants",
                fontFamily = FontFamily.Monospace,
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(bottom = 36.dp)
            )

            // Индикаторы (точки)
            Row(
                modifier = Modifier
                    .padding(bottom = 36.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                images.forEachIndexed { index, _ ->
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .padding(2.dp)
                            .then(
                                if (index == currentIndex)
                                    Modifier.background(Color.Gray, shape = CircleShape)
                                else
                                    Modifier.background(Color.LightGray, shape = CircleShape)
                            )
                    )
                }
            }

            Button(
                onClick = { },
                border = BorderStroke(2.dp, Color.Black),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = "Start Shopping",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}