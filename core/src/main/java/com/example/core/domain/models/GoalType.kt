package com.example.core.domain.models

sealed class GoalType(val name: String) {
    object LoseWeight: GoalType("lose_weight")
    object KeepWeight: GoalType("keep_weight")
    object GainWeight: GoalType("gain_weight")

    companion object {
        fun fromString(name: String): GoalType {
            return when(name) {
                "keep_weight" -> KeepWeight
                "gain_weight" -> GainWeight
                "lose_weight" -> LoseWeight
                else  -> KeepWeight
            }
        }
    }
}

