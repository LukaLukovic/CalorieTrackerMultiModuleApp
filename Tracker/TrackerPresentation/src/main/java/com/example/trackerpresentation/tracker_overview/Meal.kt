package com.example.trackerpresentation.tracker_overview

import androidx.annotation.DrawableRes
import com.example.core.util.UiText
import com.example.trackerdomain.model.MealType
import com.example.core.R


data class Meal(
    val name: UiText,
    @DrawableRes val drawableRes: Int,
    val mealType: MealType,
    val carbs: Int = 0,
    val protein: Int = 0,
    val fat: Int = 0,
    val calories: Int = 0,
    val isExpanded: Boolean = false
)


val defaultMeals = listOf(
    Meal(
        name = UiText.ResourceString(R.string.breakfast),
        drawableRes = R.drawable.ic_breakfast,
        mealType = MealType.BreakFast
    ),
    Meal(
        name = UiText.ResourceString(R.string.lunch),
        drawableRes = R.drawable.ic_lunch,
        mealType = MealType.Lunch
    ),
    Meal(
        name = UiText.ResourceString(R.string.dinner),
        drawableRes = R.drawable.ic_dinner,
        mealType = MealType.Dinner
    ),
    Meal(
        name = UiText.ResourceString(R.string.snacks),
        drawableRes = R.drawable.ic_snack,
        mealType = MealType.Snack
    ),

)