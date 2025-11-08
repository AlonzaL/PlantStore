package com.example.plantstore.plantstore.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _listPopularPlant = MutableStateFlow<List<PlantModel>>(emptyList())
    val listPopularPlant = _listPopularPlant.asStateFlow()

    private val _listNewPlant = MutableStateFlow<List<PlantModel>>(emptyList())
    val listNewPlant = _listNewPlant.asStateFlow()

    init {
        viewModelScope.launch {
            _listPopularPlant.value = MainRepository.getPopularPlant()
        }
    }
    init {
        viewModelScope.launch {
            _listNewPlant.value = MainRepository.getNewPlant()
        }
    }
}