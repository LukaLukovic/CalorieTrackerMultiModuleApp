package com.example.trackerdomain.model

import java.time.LocalDate

data class TrackedFood(
    val name: String,
    val imageUrl: String?,
    val fat: Int,
    val protein: Int,
    val carbs: Int,
    val mealType: MealType,
    val amount: Int,
    val date: LocalDate,
    val calories: Int,
    val id: Int? = null

)
