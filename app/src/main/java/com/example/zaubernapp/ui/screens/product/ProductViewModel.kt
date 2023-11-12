package com.example.zaubernapp.ui.screens.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.zaubernapp.repositories.ProductsMockRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID

class ProductViewModel(id: UUID): ViewModel() {
    private val _uiState = MutableStateFlow(
        ProductsMockRepository.getById(id)!!
    )
    val uiState: StateFlow<ProductState> = _uiState.asStateFlow()
}

class ProductViewModelFactory(private val id: UUID) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = ProductViewModel(id) as T
}