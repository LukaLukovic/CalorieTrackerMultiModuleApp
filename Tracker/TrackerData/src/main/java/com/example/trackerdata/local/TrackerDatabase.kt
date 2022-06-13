package com.example.trackerdata.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.trackerdata.local.entity.TrackedFoodEntity


@Database(
    entities = [TrackedFoodEntity::class],
    version = 1
)
abstract class TrackerDatabase: RoomDatabase() {

    abstract val dao: TrackerDao
}