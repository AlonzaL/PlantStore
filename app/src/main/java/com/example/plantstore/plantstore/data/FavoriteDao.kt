package com.example.plantstore.plantstore.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("SELECT plantId FROM favorites")
    fun getAllFavoriteIds(): Flow<List<Int>>

    @Query("SELECT COUNT(*) FROM favorites WHERE plantId = :plantId")
    suspend fun isFavorite(plantId: Int): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addToFavorites(favoriteEntity: FavoriteEntity)

    @Delete
    suspend fun removeFromFavorites(favoriteEntity: FavoriteEntity)

    @Query("DELETE FROM favorites WHERE plantId = :plantId")
    suspend fun removeFromFavoritesByPlantId(plantId: Int)

    @Query("DELETE FROM favorites")
    suspend fun clearFavorites()
}
