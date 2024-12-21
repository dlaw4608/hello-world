package com.setu.foodtrack.data.repository

import com.setu.foodtrack.data.network.NutritionApiService
import okhttp3.ResponseBody
import retrofit2.Call

class FoodRepository(private val apiService: NutritionApiService) {
    fun searchFoods(query: String): Call<ResponseBody> {
        return apiService.searchFoods(query)
    }
}
