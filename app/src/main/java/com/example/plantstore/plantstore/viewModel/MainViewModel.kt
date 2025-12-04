package com.example.plantstore.plantstore.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.navigation.PlantListType
import com.example.plantstore.plantstore.repository.AuthRepository
import com.example.plantstore.plantstore.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _listPopularPlant = MutableStateFlow<List<PlantModel>>(emptyList())
    val listPopularPlant = _listPopularPlant.asStateFlow()

    private val _listNewPlant = MutableStateFlow<List<PlantModel>>(emptyList())
    val listNewPlant = _listNewPlant.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _listPopularPlant.value = mainRepository.getPopularPlants()
            _listNewPlant.value = mainRepository.getNewPlants()
        }
    }
}