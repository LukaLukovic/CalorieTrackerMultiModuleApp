package com.example.onboardingpresentation.nutrient_goal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.preferences.Preferences
import com.example.core.domain.use_cases.FilterOutDigits
import com.example.core.util.UiEvent
import com.example.onboardingdomain.use_case.ValidateNutrients
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NutrientGoalViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits,
    private val validateNutrients: ValidateNutrients
) : ViewModel() {

    var state by mutableStateOf(NutrientGoalState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: NutrientGoalEvent) {
        when(event){
            is NutrientGoalEvent.OnCarbRatioEnter -> {
                if(event.ratio.length <= 3){
                    state = state.copy(
                        carbsRatio = filterOutDigits(event.ratio)
                    )
                }
            }
            is NutrientGoalEvent.OnFatRatioEnter -> {
                if(event.ratio.length <= 3){
                    state = state.copy(
                        fatRatio = filterOutDigits(event.ratio)
                    )
                }
            }
            is NutrientGoalEvent.OnProteinRatioEnter -> {
                if(event.ratio.length <= 3) {
                    state = state.copy(
                        proteinRatio = filterOutDigits(event.ratio)
                    )
                }
            }
            is NutrientGoalEvent.OnNextClick -> {
                val result =  validateNutrients(
                    carbsRatioText = state.carbsRatio,
                    proteinRatioText = state.proteinRatio,
                    fatRatioText = state.fatRatio
                )
                when(result) {
                    is ValidateNutrients.Result.Error -> {
                        viewModelScope.launch {
                            _uiEvent.send(UiEvent.ShowSnackbar(result.message))
                        }
                    }
                    is ValidateNutrients.Result.Success -> {
                        preferences.saveCarbsRatio(result.carbsRatio)
                        preferences.saveFatRatio(result.fatRatio)
                        preferences.saveProteinRatio(result.proteinRatio)
                        viewModelScope.launch {
                            _uiEvent.send(UiEvent.Success)
                        }
                    }
                }
            }
        }
    }
    
}