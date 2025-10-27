package com.example.plantstore.plantstore.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.plantstore.plantstore.Domain.CategoryModel
import com.example.plantstore.plantstore.Domain.PlantModel
import com.example.plantstore.plantstore.Repository.MainRepository

class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }

    fun loadPopularPlant(): LiveData<MutableList<PlantModel>> {
        return repository.loadPopularPlant()
    }

    fun loadNewPlant(): LiveData<MutableList<PlantModel>> {
        return repository.loadNewPlant()
    }

    fun loadFiltered(id: String): LiveData<MutableList<PlantModel>> {
        return repository.loadFiltered(id)
    }
}