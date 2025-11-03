package com.example.plantstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.plantstore.plantstore.viewModel.MainViewModel
import com.example.plantstore.plantstore.navigation.NavGraph
import com.example.plantstore.plantstore.viewModel.AuthViewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel = MainViewModel()
    private val authViewModel = AuthViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val nav = rememberNavController()
            NavGraph(
                mainViewModel = mainViewModel,
                authViewModel = authViewModel
            )
        }
    }
}