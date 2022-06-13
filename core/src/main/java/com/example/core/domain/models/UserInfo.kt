package com.example.core.domain.models

data class UserInfo(
    val age: Int,
    val gender: Gender,
    val weight: Float,
    val height: Int,
    val activityLevel: ActivityLevel,
    val goalType: GoalType,
    val carbRatio: Float,
    val fatRatio: Float,
    val proteinRatio: Float
)
