package com.example.trackerdomain.use_case

import com.example.trackerdomain.TrackerRepository
import com.example.trackerdomain.model.TrackableFood
import com.example.trackerdomain.model.TrackedFood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetFoodsForDate(
    private val repository: TrackerRepository
) {

    operator fun invoke(
        date: LocalDate
    ): Flow<List<TrackedFood>> {
        return repository.getFoodsForDate(date)
    }
}