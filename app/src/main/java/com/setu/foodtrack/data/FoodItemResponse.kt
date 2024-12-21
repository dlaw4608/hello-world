package com.setu.foodtrack.data

import com.google.gson.annotations.SerializedName

class FoodItemResponse(
    @SerializedName("common") val common: List<FoodItem>
)