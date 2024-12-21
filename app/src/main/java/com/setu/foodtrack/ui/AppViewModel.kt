package com.setu.foodtrack.ui
/* References used:
* https://github.com/dheeraj-bhadoria/Compose-MVVM-Retrofit-ViewMode-LiveData-Complete-Example-Android-App/blob/main/app/src/main/java/com/dheeraj/composemvvm/viewmodel/CreditCardViewModel.kt
*
*  */
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.setu.foodtrack.data.FoodItem
import com.setu.foodtrack.data.FoodItemResponse
import com.setu.foodtrack.data.repository.FoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.json.JSONObject


class AppViewModel(private val repository: FoodRepository) : ViewModel() {
    private val _foods = MutableLiveData<List<FoodItem>>()
    val foods: LiveData<List<FoodItem>> = _foods

    fun fetchFoods(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.searchFoods(query).enqueue(object : Callback<FoodItemResponse> {
                override fun onResponse(call: Call<FoodItemResponse>, response: Response<FoodItemResponse>) {
                    if (response.isSuccessful) {

                        _foods.postValue(response.body()?.common ?: emptyList())
                    } else {
                        _foods.postValue(emptyList())
                    }
                }

                override fun onFailure(call: Call<FoodItemResponse>, t: Throwable) {
                    _foods.postValue(emptyList())
                }
            })
        }
    }
}