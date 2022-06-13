package com.example.trackerdomain.use_case

import com.example.trackerdomain.TrackerRepository
import com.example.trackerdomain.model.TrackableFood
import com.example.trackerdomain.model.TrackedFood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(
        trackedFood: TrackedFood
    ) {
        repository.deleteTrackedFood(trackedFood)
    }
}