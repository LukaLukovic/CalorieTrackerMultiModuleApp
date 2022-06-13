package com.example.trackerpresentation.search

import com.example.trackerdomain.model.MealType
import com.example.trackerdomain.model.TrackableFood
import com.example.trackerdomain.model.TrackedFood
import java.time.LocalDate

sealed class SearchEvent {
    data class OnQueryChanged(val query: String): SearchEvent()
    object OnSearch: SearchEvent()
    data class OnToggleTrackableFood(val food: TrackableFood): SearchEvent()
    data class OnAmountForFoodChange(
        val amount: String,
        val food: TrackableFood
    ) : SearchEvent()
    data class OnTrackFoodClick(
        val food: TrackableFood,
        val mealType: MealType,
        val date: LocalDate
    ) : SearchEvent()
    data class OnSearchFocusChange(val isFocused: Boolean): SearchEvent()
}
