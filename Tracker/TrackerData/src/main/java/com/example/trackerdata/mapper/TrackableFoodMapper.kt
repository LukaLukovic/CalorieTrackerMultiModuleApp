package com.example.trackerdata.mapper

import com.example.trackerdata.remote.dto.Product
import com.example.trackerdomain.model.TrackableFood
import kotlin.math.roundToInt

fun Product.toTrackableFood(): TrackableFood? {

    val fatPer100g = nutriments.fat100g.roundToInt()
    val carbsPer100g = nutriments.carbohydrates100g.roundToInt()
    val proteinPer100g = nutriments.proteins100g.roundToInt()
    val caloriesPer100g = nutriments.energyKcal100g.roundToInt()
    return TrackableFood(
        name = productName ?: return null,
        carbsPer100g = carbsPer100g,
        fatPer100g = fatPer100g,
        proteinPer100g = proteinPer100g,
        imageUrl = imageFrontThumbUrl,
        caloriesPer100g = caloriesPer100g
    )
}