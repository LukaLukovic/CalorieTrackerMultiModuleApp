package com.example.onboardingdomain.use_case

import com.example.core.util.UiText

import com.example.core.R

class ValidateNutrients {

    operator fun invoke(
        carbsRatioText: String,
        fatRatioText: String,
        proteinRatioText: String,
    ): Result {
        val carbsRatio = carbsRatioText.toIntOrNull()
        val fatRatio = fatRatioText.toIntOrNull()
        val proteinRatio = proteinRatioText.toIntOrNull()
        if( carbsRatio == null || fatRatio == null || proteinRatio == null) {
            return Result.Error(
                message = UiText.ResourceString(R.string.error_invalid_values)
            )
        }
        if( carbsRatio + fatRatio + proteinRatio != 100) {
            return Result.Error(
                message = UiText.ResourceString(R.string.error_not_100_percent)
            )
        }
        return Result.Success(
            carbsRatio / 100f,
            fatRatio / 100f,
            proteinRatio / 100f
        )
    }


    sealed class Result {
        data class Success(
            val carbsRatio: Float,
            val fatRatio: Float,
            val proteinRatio: Float,
        ): Result()
        data class Error(val message: UiText): Result()
    }
}