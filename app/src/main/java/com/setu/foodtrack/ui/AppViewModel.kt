package com.setu.foodtrack.ui
/* References used:
* https://github.com/dheeraj-bhadoria/Compose-MVVM-Retrofit-ViewMode-LiveData-Complete-Example-Android-App/blob/main/app/src/main/java/com/dheeraj/composemvvm/viewmodel/CreditCardViewModel.kt
* https://www.geeksforgeeks.org/json-parsing-in-android-using-retrofit-library
*  */
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.setu.foodtrack.data.FoodItem
import com.setu.foodtrack.data.repository.FoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.json.JSONObject


class AppViewModel(private val repository: FoodRepository) : ViewModel() {
    private val _foods = MutableLiveData<String>()
    val foods: LiveData<String> = _foods

    fun fetchFoods(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.searchFoods(query).enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful) {
                        // Assuming response.body() is a String
                        _foods.postValue(response.body())
                    } else {
                        _foods.postValue("Error: ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    _foods.postValue("Failure: ${t.message}")
                }
            })
        }
    }
}