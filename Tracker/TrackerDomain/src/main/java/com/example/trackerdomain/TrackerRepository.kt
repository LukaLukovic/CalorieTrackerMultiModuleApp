package com.example.trackerdomain

import com.example.trackerdomain.model.TrackableFood
import com.example.trackerdomain.model.TrackedFood
import java.time.LocalDate
import kotlinx.coroutines.flow.Flow

interface TrackerRepository {

    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>


    suspend fun insertTrackedFood(food: TrackedFood)

    suspend fun deleteTrackedFood(food: TrackedFood)

    fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>>
}