package com.example.zaubernapp.viewmodels

import androidx.lifecycle.ViewModel
import com.example.zaubernapp.repositories.ProductsMockRepository
import com.example.zaubernapp.states.ProductsListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductsListViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        ProductsListState(
            products = ProductsMockRepository.getAll()
        )
    )
    val uiState: StateFlow<ProductsListState> = _uiState.asStateFlow()

}