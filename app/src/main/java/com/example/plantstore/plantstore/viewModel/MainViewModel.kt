package com.example.plantstore.plantstore.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plantstore.plantstore.domain.PlantModel
import com.example.plantstore.plantstore.repository.MainRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {

    private var allPlantsCache = listOf<PlantModel>()

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
            val plantsDeferred = async { mainRepository.getAllPlants() }
            val favsDeferred = async { mainRepository.getUserFavoriteIds() }

            val rawPlants = plantsDeferred.await()
            val favIds = favsDeferred.await().mapNotNull { it.toIntOrNull() }

            allPlantsCache = rawPlants.map { plant ->
                plant.copy(isFavorite = favIds.contains(plant.id))
            }

            refreshUiLists()
        }
    }

    private fun refreshUiLists() {
        // Было: it.isPopular -> Стало: it.popularPlant
        val popular = allPlantsCache.filter { it.isPopular }

        // Было: it.isNew -> Стало: it.newPlant
        val new = allPlantsCache.filter { it.isNew }

        Log.d("MyLog", "ViewModel: Filtered Popular: ${popular.size}")
        Log.d("MyLog", "ViewModel: Filtered New: ${new.size}")

        _listPopularPlant.value = popular
        _listNewPlant.value = new
    }

    fun onFavoriteClick(plant: PlantModel) {
        viewModelScope.launch {
            val newFavStatus = !plant.isFavorite

            allPlantsCache = allPlantsCache.map {
                if (it.id == plant.id) it.copy(isFavorite = newFavStatus) else it
            }
            refreshUiLists()

            val success = mainRepository.toggleFavorite(plant.id)

            if (success != newFavStatus) {
                allPlantsCache = allPlantsCache.map {
                    if (it.id == plant.id) it.copy(isFavorite = success) else it
                }
                refreshUiLists()
            }
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    fun onCategorySelect(category: String) {
        _selectedCategory.value = category
    }

    fun getPlantById(id: Int): PlantModel? {
        return allPlantsCache.find { it.id == id }
    }
}