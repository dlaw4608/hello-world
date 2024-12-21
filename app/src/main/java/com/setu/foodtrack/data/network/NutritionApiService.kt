package com.setu.foodtrack.data.network
/* References used:
https://github.com/dheeraj-bhadoria/Compose-MVVM-Retrofit-ViewMode-LiveData-Complete-Example-Android-App/blob/main/app/src/main/java/com/dheeraj/composemvvm/service/CreditCardService.kt */
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import com.setu.foodtrack.data.FoodItem
import okhttp3.ResponseBody

interface NutritionApiService {
    @Headers(
        "x-app-id: d96b55c7",
        "x-app-key: a967ba00a90c17ef496a6605ff32778c"
    )
    @GET("search/instant")
    fun searchFoods(
        @Query("query") query: String
    ): Call<ResponseBody>
}
