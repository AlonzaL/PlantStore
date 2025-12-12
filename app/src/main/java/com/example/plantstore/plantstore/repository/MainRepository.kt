package com.example.plantstore.plantstore.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.plantstore.plantstore.domain.CategoryModel
import com.example.plantstore.plantstore.domain.PlantModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
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
    private val auth = FirebaseAuth.getInstance()

    suspend fun getAllPlants(): List<PlantModel> {
        return try {
            // Используем Source.SERVER, чтобы точно не брать старый кэш
            val snapshot = fs.collection("plants").get(com.google.firebase.firestore.Source.SERVER).await()
            val list = mutableListOf<PlantModel>()

            for (doc in snapshot.documents) {
                // БЕЗОПАСНЫЙ ПАРСИНГ
                // Мы используем doc.get("..."), который возвращает Any? (что угодно)
                // А потом приводим к нужному типу через toString()

                val plant = PlantModel(
                    id = doc.get("id").toString().toIntOrNull() ?: 0,

                    title = doc.getString("title") ?: "",
                    category = doc.getString("category") ?: "",
                    description = doc.getString("description") ?: "",

                    // Цену тоже читаем безопасно (справится и с 15, и с 15.0, и с "15")
                    price = doc.get("price").toString().toDoubleOrNull() ?: 0.0,

                    heightFlower = doc.getString("heightFlower") ?: "",
                    potSize = doc.getString("potSize") ?: "",
                    potType = doc.getString("potType") ?: "",

                    imagePath = (doc.get("imagePath") as? List<String>) ?: emptyList(),

                    // САМОЕ ГЛАВНОЕ:
                    // doc.get(...) берет значение. toString() превращает true в "true".
                    // Сравниваем строку с "true". Это работает и для Boolean, и для String в базе.
                    isPopular = doc.get("popularPlant").toString() == "true",

                    isNew = doc.get("newPlant").toString() == "true",

                    numberInCart = doc.get("numberInCart").toString().toIntOrNull() ?: 0
                )
                list.add(plant)
            }

            Log.d("MyLog", "Repo: Successfully loaded ${list.size} plants")
            return list
        } catch (e: Exception) {
            Log.e("MyLog", "Repo: Error loading plants", e)
            emptyList()
        }
    }

    suspend fun getUserFavoriteIds(): List<String> {
        val userId = auth.currentUser?.uid ?: return emptyList()
        return try {
            val snapshot = fs.collection("users")
                .document(userId)
                .collection("favorites")
                .get()
                .await()
            snapshot.documents.map { it.id }
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun toggleFavorite(plantId: Int): Boolean {
        val userId = auth.currentUser?.uid ?: return false
        val favRef = fs.collection("users")
            .document(userId)
            .collection("favorites")
            .document(plantId.toString())

        return try {
            val doc = favRef.get().await()
            if (doc.exists()) {
                favRef.delete().await()
                false
            } else {
                favRef.set(mapOf("timestamp" to System.currentTimeMillis())).await()
                true
            }
        } catch (e: Exception) {
            false
        }
    }
}