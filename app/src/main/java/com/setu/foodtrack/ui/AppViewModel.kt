package com.setu.foodtrack.ui
/* References used:
* https://github.com/dheeraj-bhadoria/Compose-MVVM-Retrofit-ViewMode-LiveData-Complete-Example-Android-App/blob/main/app/src/main/java/com/dheeraj/composemvvm/viewmodel/CreditCardViewModel.kt
* https://www.geeksforgeeks.org/json-parsing-in-android-using-retrofit-library
*  */
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.setu.foodtrack.data.FoodItem
import com.setu.foodtrack.data.repository.FoodRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.json.JSONObject


class AppViewModel(private val repository: FoodRepository) : ViewModel() {

    private val _foods = MutableLiveData<List<FoodItem>>()
    val foods: LiveData<List<FoodItem>> = _foods


    fun fetchFoods(query: String) {
        repository.searchFoods(query).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    val parsedFoods = parseFoods(response.body() ?: "")
                    _foods.postValue(parsedFoods)
                } else {
                    _foods.postValue(emptyList())
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                _foods.postValue(emptyList())
            }
        })

    }
    private fun parseFoods(jsonString: String): List<FoodItem> {
        val foodItems = mutableListOf<FoodItem>()
        val jsonObject = JSONObject(jsonString)
        val foodsArray = jsonObject.getJSONArray("foods")

        for (i in 0 until foodsArray.length()) {
            val food = foodsArray.getJSONObject(i)
            val name = food.getString("food_name")
            val calories = food.getDouble("calories")
            foodItems.add(FoodItem(name, calories))
        }

        return foodItems
    }

}