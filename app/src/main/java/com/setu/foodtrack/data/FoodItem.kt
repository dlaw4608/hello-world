package com.setu.foodtrack.data

data class FoodItem(
    val id: Int,
    val name: String,
    val calories: Double,
    val carbs: Double,
    val protein: Double,
    val fat: Double
)