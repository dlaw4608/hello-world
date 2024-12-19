package com.setu.foodtrack.ui
/* References used:
* https://github.com/dheeraj-bhadoria/Compose-MVVM-Retrofit-ViewMode-LiveData-Complete-Example-Android-App/blob/main/app/src/main/java/com/dheeraj/composemvvm/viewmodel/CreditCardViewModel.kt
*  */
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.setu.foodtrack.data.repository.FoodRepository
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodViewModel(private val repository: FoodRepository) : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String> = _response

    fun fetchFoods(query: String) {
        repository.searchFoods(query).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    _response.postValue(response.body())
                } else {
                    _response.postValue("Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.postValue("Failure: ${t.message}")
            }
        })
    }
}