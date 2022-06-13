package com.example.trackerpresentation.search

import com.example.trackerdomain.model.TrackableFood

data class SearchState(
    val query: String = "",
    val isHintVisible: Boolean = true,
    val isSearching: Boolean = false,
    val trackableFood: List<TrackableFoodUiState> = emptyList()
)
