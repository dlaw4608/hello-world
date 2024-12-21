package com.setu.foodtrack
/* https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-factories*/
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.setu.foodtrack.data.network.RetrofitClient
import com.setu.foodtrack.data.repository.FoodRepository
import com.setu.foodtrack.ui.FoodSearchScreen
import com.setu.foodtrack.ui.AppViewModel
import com.setu.foodtrack.ui.AppViewModelFactory
import com.setu.foodtrack.ui.theme.FoodTrackTheme

class MainActivity : ComponentActivity() {
    private val repository = FoodRepository(RetrofitClient.apiService)


    private val viewModel: AppViewModel by viewModels {
        AppViewModelFactory(repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodTrackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    // Pass the ViewModel to the Composable
                    FoodSearchScreen(viewModel = viewModel)
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodTrackTheme {
        Greeting("Android")
    }
}