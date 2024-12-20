package com.setu.foodtrack.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FoodSearchScreen(viewModel: AppViewModel = viewModel()) {
    var searchText by remember { mutableStateOf("") }

    // Observing changes in the LiveData from ViewModel
    val foods = viewModel.foods.observeAsState("")

    Column {
        BasicTextField(
            value = searchText,
            onValueChange = { searchText = it },
            decorationBox = { innerTextField ->
                if (searchText.isEmpty()) {
                    Text("Enter food name")
                }
                innerTextField()
            }
        )
        Button(onClick = { viewModel.fetchFoods(searchText) }) {
            Text("Search")
        }

        Text(text = foods.value) // Displaying the result
    }
}
