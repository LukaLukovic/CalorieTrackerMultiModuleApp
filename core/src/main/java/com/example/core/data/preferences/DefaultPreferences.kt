package com.example.core.data.preferences

import android.content.SharedPreferences
import com.example.core.domain.models.ActivityLevel
import com.example.core.domain.models.Gender
import com.example.core.domain.models.GoalType
import com.example.core.domain.models.UserInfo
import com.example.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPref: SharedPreferences
): Preferences {

    override fun saveGender(gender: Gender) {
        sharedPref.edit().putString(Preferences.KEY_GENDER, gender.name).apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPref.edit().putFloat(Preferences.KEY_WEIGHT, weight).apply()
    }

    override fun saveHeight(height: Int) {
        sharedPref.edit().putInt(Preferences.KEY_HEIGHT, height).apply()
    }

    override fun saveAge(age: Int) {
        sharedPref.edit().putInt(Preferences.KEY_AGE, age).apply()
    }

    override fun saveActivityLevel(activityLevel: ActivityLevel) {
        sharedPref.edit().putString(Preferences.KEY_ACTIVITY_LEVEL, activityLevel.name).apply()
    }

    override fun saveGoalType(goalType: GoalType) {
        sharedPref.edit().putString(Preferences.KEY_GOAL_TYPE, goalType.name).apply()
    }

    override fun saveCarbsRatio(ratio: Float) {
        sharedPref.edit().putFloat(Preferences.KEY_CARB_RATIO, ratio).apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPref.edit().putFloat(Preferences.KEY_FAT_RATIO, ratio).apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPref.edit().putFloat(Preferences.KEY_PROTEIN_RATIO, ratio).apply()
    }

    override fun saveShouldShowOnBoarding(shouldShow: Boolean) {
        sharedPref.edit()
            .putBoolean(Preferences.KEY_SHOULD_SHOW_ON_BOARDING, shouldShow)
            .apply()
    }

    override fun loadShouldShowOnBoarding(): Boolean {
        return sharedPref.getBoolean(Preferences.KEY_SHOULD_SHOW_ON_BOARDING, true)
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharedPref.getInt(Preferences.KEY_AGE, -1)
        val height = sharedPref.getInt(Preferences.KEY_HEIGHT, -1)
        val weight = sharedPref.getFloat(Preferences.KEY_WEIGHT, -1f)
        val gender = sharedPref.getString(Preferences.KEY_GENDER, null)
        val activityLevel = sharedPref.getString(Preferences.KEY_ACTIVITY_LEVEL, null)
        val goalType = sharedPref.getString(Preferences.KEY_GOAL_TYPE, null)
        val carbRatio = sharedPref.getFloat(Preferences.KEY_CARB_RATIO, -1F)
        val fatRatio = sharedPref.getFloat(Preferences.KEY_FAT_RATIO, -1F)
        val proteinRatio = sharedPref.getFloat(Preferences.KEY_PROTEIN_RATIO, -1F)
        return UserInfo(
            age,
            Gender.fromString(gender ?: "male"),
            weight,
            height,
            ActivityLevel.fromString(activityLevel ?: "medium"),
            GoalType.fromString(goalType ?: "keep_weight"),
            carbRatio,
            fatRatio,
            proteinRatio
        )
    }
}