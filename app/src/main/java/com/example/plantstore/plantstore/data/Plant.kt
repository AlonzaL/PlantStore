package com.example.plantstore.plantstore.data

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Plant(
    val id: Int,
    val name: String,
    val price: Double,
    val imageUrl: String,
    val description: String = "",
    val category: String = "Indoor",
    val isPopular: Boolean = false
)

@Entity(tableName = "cart_items")
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val plantId: Int,
    val plantName: String,
    val plantPrice: Double,
    val plantImageUrl: String,
    val quantity: Int = 1
)

@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey
    val plantId: Int
)

object PlantData {

    val plants = listOf(
        Plant(
            id = 1,
            name = "Monstera Deliciosa",
            price = 29.99,
            imageUrl = "https://source.unsplash.com/200x200/?monstera",
            description = "A popular houseplant with large, glossy leaves.",
            category = "Indoor",
            isPopular = true
        ),
        Plant(
            id = 2,
            name = "Snake Plant",
            price = 19.99,
            imageUrl = "https://source.unsplash.com/200x200/?snake-plant",
            description = "Low-maintenance plant perfect for beginners.",
            category = "Indoor",
            isPopular = true
        ),
        Plant(
            id = 3,
            name = "Fiddle Leaf Fig",
            price = 39.99,
            imageUrl = "https://source.unsplash.com/200x200/?fiddle-leaf-fig",
            description = "Elegant tree-like plant with large leaves.",
            category = "Indoor",
            isPopular = true
        ),
        Plant(
            id = 4,
            name = "Pothos",
            price = 14.99,
            imageUrl = "https://source.unsplash.com/200x200/?pothos",
            description = "Trailing vine plant, easy to care for.",
            category = "Indoor",
            isPopular = true
        ),
        Plant(
            id = 5,
            name = "Rubber Plant",
            price = 24.99,
            imageUrl = "https://source.unsplash.com/200x200/?rubber-plant",
            description = "Glossy leaves and easy maintenance.",
            category = "Indoor",
            isPopular = true
        ),
        Plant(
            id = 6,
            name = "Peace Lily",
            price = 22.99,
            imageUrl = "https://source.unsplash.com/200x200/?peace-lily",
            description = "Beautiful white flowers and air-purifying.",
            category = "Indoor",
            isPopular = true
        ),
        Plant(
            id = 7,
            name = "Rose Bush",
            price = 34.99,
            imageUrl = "https://source.unsplash.com/200x200/?rose",
            description = "Classic flowering shrub for outdoor gardens.",
            category = "Outdoor",
            isPopular = false
        ),
        Plant(
            id = 8,
            name = "Lavender",
            price = 16.99,
            imageUrl = "https://source.unsplash.com/200x200/?lavender",
            description = "Fragrant herb perfect for gardens.",
            category = "Outdoor",
            isPopular = false
        ),
        Plant(
            id = 9,
            name = "Succulent Mix",
            price = 12.99,
            imageUrl = "https://source.unsplash.com/200x200/?succulent",
            description = "Collection of colorful succulents.",
            category = "Indoor",
            isPopular = false
        ),
        Plant(
            id = 10,
            name = "Orchid",
            price = 45.99,
            imageUrl = "https://source.unsplash.com/200x200/?orchid",
            description = "Elegant flowering plant.",
            category = "Flowering",
            isPopular = false
        ),
        Plant(
            id = 11,
            name = "Aloe Vera",
            price = 18.99,
            imageUrl = "https://source.unsplash.com/200x200/?aloe-vera",
            description = "Medicinal plant with healing properties.",
            category = "Indoor",
            isPopular = false
        ),
        Plant(
            id = 12,
            name = "Spider Plant",
            price = 15.99,
            imageUrl = "https://source.unsplash.com/200x200/?spider-plant",
            description = "Easy-care plant that produces baby plants.",
            category = "Indoor",
            isPopular = false
        ),
        Plant(
            id = 13,
            name = "Jade Plant",
            price = 21.99,
            imageUrl = "https://source.unsplash.com/200x200/?jade-plant",
            description = "Symbol of good luck and prosperity.",
            category = "Indoor",
            isPopular = false
        ),
        Plant(
            id = 14,
            name = "Bamboo",
            price = 26.99,
            imageUrl = "https://source.unsplash.com/200x200/?bamboo",
            description = "Fast-growing plant for privacy screens.",
            category = "Outdoor",
            isPopular = false
        ),
        Plant(
            id = 15,
            name = "Tulip Bulbs",
            price = 8.99,
            imageUrl = "https://source.unsplash.com/200x200/?tulip",
            description = "Spring flowering bulbs in various colors.",
            category = "Flowering",
            isPopular = false
        ),
        Plant(
            id = 16,
            name = "Fern",
            price = 17.99,
            imageUrl = "https://source.unsplash.com/200x200/?fern",
            description = "Lush green foliage plant.",
            category = "Indoor",
            isPopular = false
        ),
        Plant(
            id = 17,
            name = "Cactus",
            price = 13.99,
            imageUrl = "https://source.unsplash.com/200x200/?cactus",
            description = "Low-water desert plant.",
            category = "Indoor",
            isPopular = false
        ),
        Plant(
            id = 18,
            name = "Hydrangea",
            price = 32.99,
            imageUrl = "https://source.unsplash.com/200x200/?hydrangea",
            description = "Large flowering shrub with colorful blooms.",
            category = "Outdoor",
            isPopular = false
        ),
        Plant(
            id = 19,
            name = "Mint",
            price = 9.99,
            imageUrl = "https://source.unsplash.com/200x200/?mint",
            description = "Aromatic herb for cooking and tea.",
            category = "Outdoor",
            isPopular = false
        ),
        Plant(
            id = 20,
            name = "Lily",
            price = 28.99,
            imageUrl = "https://source.unsplash.com/200x200/?lily",
            description = "Elegant flowering plant with large blooms.",
            category = "Flowering",
            isPopular = false
        )
    )

    val categories = listOf("All", "Indoor", "Outdoor", "Flowering")
}