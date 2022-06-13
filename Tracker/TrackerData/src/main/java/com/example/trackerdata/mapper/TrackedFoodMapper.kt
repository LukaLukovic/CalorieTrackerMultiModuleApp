package com.example.trackerdata.mapper

import com.example.trackerdata.local.entity.TrackedFoodEntity
import com.example.trackerdomain.model.MealType
import com.example.trackerdomain.model.TrackedFood
import java.time.LocalDate


fun TrackedFoodEntity.toTrackedFood(): TrackedFood {

    return TrackedFood(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        mealType = MealType.fromString(type),
        amount = amount,
        date = LocalDate.of(year, month, dayOfMonth),
        calories = calories,
        id = id
    )
}


fun TrackedFood.toTrackedFoodEntity(): TrackedFoodEntity {

    return TrackedFoodEntity(
        carbs = carbs,
        protein = protein,
        fat = fat,
        name = name,
        imageUrl = imageUrl,
        calories = calories,
        type = mealType.name,
        amount = amount,
        dayOfMonth = date.dayOfMonth,
        month = date.monthValue,
        year = date.year,
        id = id
    )
}