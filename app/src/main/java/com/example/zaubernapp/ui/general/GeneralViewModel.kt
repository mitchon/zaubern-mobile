package com.example.zaubernapp.ui.general

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GeneralViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        GeneralState(
            canNavigateUp = false,
            canDropDown = true
        )
    )

    val uiState: StateFlow<GeneralState> = _uiState.asStateFlow()

    fun setCanDropDown(state: Boolean) {
        _uiState.update { it.copy(canDropDown = state) }
    }

    fun setCanNavigateUp(state: Boolean) {
        _uiState.update { it.copy(canNavigateUp = state) }
    }
}