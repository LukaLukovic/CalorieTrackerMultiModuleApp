package com.example.trackerdata.repository

import com.example.trackerdata.local.TrackerDao
import com.example.trackerdata.mapper.toTrackableFood
import com.example.trackerdata.mapper.toTrackedFood
import com.example.trackerdata.mapper.toTrackedFoodEntity
import com.example.trackerdata.remote.OpenFoodApi
import com.example.trackerdomain.TrackerRepository
import com.example.trackerdomain.model.TrackableFood
import com.example.trackerdomain.model.TrackedFood
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class TrackerRepositoryImpl(
    private val dao: TrackerDao,
    private val foodApi: OpenFoodApi
): TrackerRepository {

    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int,
    ): Result<List<TrackableFood>> {
        return try {
            val resultDto = foodApi.searchFood(
                query = query,
                page = page,
                pageSize = pageSize
            )
            Result.success(resultDto.products.mapNotNull {
                it.toTrackableFood()
            })
        } catch(e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun insertTrackedFood(food: TrackedFood) {
       dao.insertTrackedFood(food.toTrackedFoodEntity())
    }

    override suspend fun deleteTrackedFood(food: TrackedFood) {
        dao.deleteTrackedFood(food.toTrackedFoodEntity())
    }

    override fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>> {
        return dao.getFoodsForDate(
            localDate.dayOfMonth,
            localDate.monthValue,
            localDate.year
        ).map{ list ->
            list.map { it.toTrackedFood() }
        }
    }
}