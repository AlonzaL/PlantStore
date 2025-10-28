package com.example.plantstore.plantstore.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.plantstore.plantstore.domain.CategoryModel
import com.example.plantstore.plantstore.domain.PlantModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class MainRepository {

    private val firebaseDatabase = FirebaseDatabase.getInstance()

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        val listData = MutableLiveData<MutableList<CategoryModel>>()
        val ref = firebaseDatabase.getReference("Category")
        ref.addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var list = mutableListOf<CategoryModel>()
                    for (childSnapshot in snapshot.children) {
                        val item = childSnapshot.getValue(CategoryModel::class.java)
                        item?.let {
                            list.add(it)
                        }
                    }
                    listData.value = list
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            }
        )
        return listData
    }

    fun loadPopularPlant(): LiveData<MutableList<PlantModel>> {
        val listData = MutableLiveData<MutableList<PlantModel>>()
        val ref = firebaseDatabase.getReference("Plants")
        val query: Query = ref.orderByChild("PopularPlant").equalTo(true)
        query.addListenerForSingleValueEvent(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val lists = mutableListOf<PlantModel>()
                    for (childSnapshot in snapshot.children) {
                        val list = childSnapshot.getValue(PlantModel::class.java)
                        if (list != null) {
                            lists.add(list)
                        }
                    }
                    listData.value = lists
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            }
        )
        return listData
    }

    fun loadNewPlant(): LiveData<MutableList<PlantModel>> {
        val listData = MutableLiveData<MutableList<PlantModel>>()
        val ref = firebaseDatabase.getReference("Plants")
        val query: Query = ref.orderByChild("NewPlant").equalTo(true)
        query.addListenerForSingleValueEvent(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val lists = mutableListOf<PlantModel>()
                    for (childSnapshot in snapshot.children) {
                        val list = childSnapshot.getValue(PlantModel::class.java)
                        if (list != null) {
                            lists.add(list)
                        }
                    }
                    listData.value = lists
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            }
        )
        return listData
    }

    fun loadFiltered(
        id: String
    ): LiveData<MutableList<PlantModel>> {
        val listData = MutableLiveData<MutableList<PlantModel>>()
        val ref = firebaseDatabase.getReference("Plants")
        val query: com.google.firebase.database.Query = ref.orderByChild("CategoryId").equalTo(id)
        query.addListenerForSingleValueEvent(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val lists = mutableListOf<PlantModel>()
                    for(childSnapshot in snapshot.children) {
                        val list = childSnapshot.getValue(PlantModel::class.java)
                        if(list != null) {
                            lists.add(list)
                        }
                    }
                    listData.value = lists
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            }
        )
        return listData
    }
}