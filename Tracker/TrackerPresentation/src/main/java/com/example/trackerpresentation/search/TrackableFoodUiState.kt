package com.example.trackerpresentation.search

import com.example.trackerdomain.model.TrackableFood
import com.example.trackerdomain.model.TrackedFood

data class TrackableFoodUiState(
    val food: TrackableFood,
    val isExpanded: Boolean = false,
    val amount: String = ""
)
