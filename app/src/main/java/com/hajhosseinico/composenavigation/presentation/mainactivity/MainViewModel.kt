package com.hajhosseinico.composenavigation.presentation.mainactivity

import androidx.lifecycle.ViewModel
import com.hajhosseinico.composenavigation.domain.HomeFeatureModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    // For managing features in HomeScreen
    private val _features = MutableStateFlow<List<HomeFeatureModel>>(emptyList())
    val features: StateFlow<List<HomeFeatureModel>> = _features.asStateFlow()

    // Update feature list
    fun updateFeatures(newFeatures: List<HomeFeatureModel>) {
        _features.value = newFeatures
    }
}

