package com.example.plantstore.plantstore.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _listPopularPlant = MutableStateFlow<List<PlantModel>>(emptyList())
    val listPopularPlant = _listPopularPlant.asStateFlow()

    private val _listNewPlant = MutableStateFlow<List<PlantModel>>(emptyList())
    val listNewPlant = _listNewPlant.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    val categories = listOf("Indoor", "Outdoor", "Artificial")

    private val _selectedCategory = MutableStateFlow("Indoor")
    val selectedCategory = _selectedCategory.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _listPopularPlant.value = mainRepository.getPopularPlants()
            _listNewPlant.value = mainRepository.getNewPlants()
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    fun onCategorySelect(category: String) {
        _selectedCategory.value = category
    }
}