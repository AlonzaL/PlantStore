package com.example.plantstore.plantstore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.plantstore.plantstore.domain.CategoryModel
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.repository.MainRepository

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