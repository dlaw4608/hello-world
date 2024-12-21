package com.setu.foodtrack.data

data class FoodResponse(
    val common: List<FoodItem>,
    val branded: List<FoodItem>
)

data class FoodItem(
    val name: String,

)