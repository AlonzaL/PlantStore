package com.example.plantstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.viewModel.MainViewModel
import com.example.plantstore.plantstore.navigation.NavGraph
import com.example.plantstore.plantstore.viewModel.AuthViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

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
            //MainFs()
        }
    }
}

@Composable
fun MainFs() {
    val fs = Firebase.firestore
    val listPlantAll = remember { mutableStateOf(emptyList<PlantModel>()) }

    fs.collection("plants").get().addOnCompleteListener {task ->
        listPlantAll.value = task.result.toObjects(PlantModel::class.java)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn {
            items(listPlantAll.value) {plant ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = plant.Title
                    )
                    Text(
                        text = plant.Price.toString()
                    )
                }
            }
        }
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                fs.collection("plants")
                    .document().set(
                        PlantModel(
                            Id = 0,
                            Title = "Цветок 8",
                            Category = "Artificial",
                            Description = "Indoor plants have many health and decorative benefits such as allergy relief, mood improvements, humidity increase in rooms, air purification, better sleep, stress release, or even better digestion. As medical science has made progress, more and more benefits of having indoor plants are being discovered.",
                            Price = 17.0,
                            PriceId = 0,
                            HeightFlower = "2ft.",
                            PotSize = "6 Inches",
                            PotType = "Ceramic",
                            ImagePath = listOf("https://res.cloudinary.com/dovql3xtu/image/upload/v1761682636/flower_1_2_efyot0.png", "https://res.cloudinary.com/dovql3xtu/image/upload/v1761682636/flower_1_1_nnce2z.png"),
                            isFavorite = false,
                            PopularPlant = true,
                            NewPlant = true,
                            numberInCart = 0
                        )
                    )
            }
        ) {
            Text(
                text = "Добавить"
            )
        }
    }


}