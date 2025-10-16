package com.example.plantstore.plantstore.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlantRepository @Inject constructor(
    private val cartDao: CartDao,
    private val favoriteDao: FavoriteDao
) {

    // Plant data
    fun getAllPlants(): List<Plant> = PlantData.plants

    fun getPopularPlants(): List<Plant> = PlantData.plants.filter { it.isPopular }

    fun getPlantsByCategory(category: String): List<Plant> {
        return if (category == "All") {
            PlantData.plants
        } else {
            PlantData.plants.filter { it.category == category }
        }
    }

    fun searchPlants(query: String): List<Plant> {
        return PlantData.plants.filter {
            it.name.contains(query, ignoreCase = true) ||
                    it.description.contains(query, ignoreCase = true) ||
                    it.category.contains(query, ignoreCase = true)
        }
    }

    fun getPlantById(id: Int): Plant? = PlantData.plants.find { it.id == id }

    fun getCategories(): List<String> = PlantData.categories

    // Cart operations
    fun getAllCartItems(): Flow<List<CartEntity>> = cartDao.getAllCartItems()

    suspend fun addToCart(plant: Plant) {
        val existingItem = cartDao.getCartItemByPlantId(plant.id)
        if (existingItem != null) {
            val updatedItem = existingItem.copy(quantity = existingItem.quantity + 1)
            cartDao.updateCartItem(updatedItem)
        } else {
            val cartItem = CartEntity(
                plantId = plant.id,
                plantName = plant.name,
                plantPrice = plant.price,
                plantImageUrl = plant.imageUrl
            )
            cartDao.insertCartItem(cartItem)
        }
    }

    suspend fun removeFromCart(plantId: Int) {
        cartDao.deleteCartItemByPlantId(plantId)
    }

    suspend fun updateCartItemQuantity(plantId: Int, quantity: Int) {
        val cartItem = cartDao.getCartItemByPlantId(plantId)
        if (cartItem != null) {
            if (quantity <= 0) {
                cartDao.deleteCartItemByPlantId(plantId)
            } else {
                val updatedItem = cartItem.copy(quantity = quantity)
                cartDao.updateCartItem(updatedItem)
            }
        }
    }

    suspend fun getCartItemCount(): Int = cartDao.getCartItemCount()

    suspend fun getCartTotal(): Double = cartDao.getTotalPrice() ?: 0.0

    suspend fun clearCart() {
        cartDao.clearCart()
    }

    // Favorites operations
    fun getAllFavoriteIds(): Flow<List<Int>> = favoriteDao.getAllFavoriteIds()

    suspend fun isFavorite(plantId: Int): Boolean {
        return favoriteDao.isFavorite(plantId) > 0
    }

    suspend fun toggleFavorite(plantId: Int) {
        val isCurrentlyFavorite = favoriteDao.isFavorite(plantId) > 0
        if (isCurrentlyFavorite) {
            favoriteDao.removeFromFavoritesByPlantId(plantId)
        } else {
            favoriteDao.addToFavorites(FavoriteEntity(plantId))
        }
    }

    suspend fun clearFavorites() {
        favoriteDao.clearFavorites()
    }
}