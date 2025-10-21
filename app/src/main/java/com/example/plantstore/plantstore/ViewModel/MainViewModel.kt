package com.example.plantstore.plantstore.ViewModel

import androidx.lifecycle.LiveData
import com.example.plantstore.plantstore.Domain.CategoryModel
import com.example.plantstore.plantstore.Domain.PlantModel
import com.example.plantstore.plantstore.Repository.MainRepository

class MainViewModel {
    private val repository = MainRepository()

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }

    fun loadFiltered(id: String): LiveData<MutableList<PlantModel>> {
        return repository.loadFiltered(id)
    }
}