package com.setu.foodtrack.data.repository

import com.setu.foodtrack.data.network.NutritionApiService
import retrofit2.Call

class FoodRepository(private val apiService: NutritionApiService) {
    fun searchFoods(query: String): Call<String> {
        return apiService.searchFoods(query)
    }
}
