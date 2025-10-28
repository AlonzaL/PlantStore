package com.example.plantstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.plantstore.plantstore.viewModel.MainViewModel
import com.example.plantstore.plantstore.navigation.NavGraph

class MainActivity : ComponentActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val nav = rememberNavController()
            NavGraph(
                viewModel = viewModel
            )
        }
    }
}