package com.example.plantstore.plantstore.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.plantstore.plantstore.domain.CategoryModel
import com.example.plantstore.plantstore.domain.PlantModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObjects
import kotlinx.coroutines.tasks.await

object MainRepository {

    private val fs = FirebaseFirestore.getInstance()

    suspend fun getPopularPlants(): List<PlantModel> {
        return try {
            fs.collection("plants")
                .whereEqualTo("popularPlant", true)
                .get()
                .await()
                .toObjects(PlantModel::class.java)
        } catch (e: Exception) {
            Log.e("MainRepository", "Error loading popular plants", e)
            emptyList()
        }
    }

    suspend fun getNewPlants(): List<PlantModel> {
        return try {
            fs.collection("plants")
                .whereEqualTo("newPlant", true)
                .get()
                .await()
                .toObjects(PlantModel::class.java)
        } catch (e: Exception) {
            Log.e("MainRepository", "Error loading new plants", e)
            emptyList()
        }
    }


}