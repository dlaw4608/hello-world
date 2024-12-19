package com.setu.foodtrack.data.network
/* References used:
https://github.com/dheeraj-bhadoria/Compose-MVVM-Retrofit-ViewMode-LiveData-Complete-Example-Android-App/blob/main/app/src/main/java/com/dheeraj/composemvvm/service/CreditCardService.kt */
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NutritionApiService {
    @Headers(
        "x-app-id: YOUR_APP_ID",
        "x-app-key: YOUR_API_KEY"
    )
    @GET("foods/search")
    fun searchFoods(
        @Query("query") query: String
    ): Call<String>
}
