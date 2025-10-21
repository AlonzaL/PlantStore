package com.example.plantstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.plantstore.plantstore.Screen.Main.MainScreen
import com.example.plantstore.plantstore.Screen.WelcomeScreen
import com.example.plantstore.ui.theme.PlantStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlantStoreTheme {
                WelcomeScreen()
            }
        }
    }
}