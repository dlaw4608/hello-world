package com.setu.foodtrack.data

import com.google.gson.annotations.SerializedName


data class FoodItem(
    @SerializedName("food_name") val name: String,

    )