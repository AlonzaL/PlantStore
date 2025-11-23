package com.example.plantstore.plantstore.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.navigation.PlantListType
import com.example.plantstore.plantstore.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _listPopularPlant = MutableStateFlow<List<PlantModel>>(emptyList())
    val listPopularPlant = _listPopularPlant.asStateFlow()
    private val _listNewPlant = MutableStateFlow<List<PlantModel>>(emptyList())
    val listNewPlant = _listNewPlant.asStateFlow()
    private val _displayedPlants = MutableStateFlow<List<PlantModel>>(emptyList())
    val displayedPlants: StateFlow<List<PlantModel>> = _displayedPlants.asStateFlow()

    private val _displayedTitle = MutableStateFlow("")
    //val displayedTitle: StateFlow<String> = _displayedTitle.asStateFlow()

    init {
        viewModelScope.launch {
            _listPopularPlant.value = MainRepository.getPopularPlant()
            _listNewPlant.value = MainRepository.getNewPlant()
        }
    }

    fun loadPlantList(listType: PlantListType) {
        when (listType) {
            PlantListType.POPULAR -> {
                _displayedPlants.value = _listPopularPlant.value
                _displayedTitle.value = "Популярные растения"
            }
            PlantListType.NEW -> {
                _displayedPlants.value = _listNewPlant.value
                _displayedTitle.value = "Новинки"
            }
        }
    }
}