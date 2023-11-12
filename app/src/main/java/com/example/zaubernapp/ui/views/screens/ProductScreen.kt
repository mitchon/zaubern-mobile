package com.example.zaubernapp.ui.views.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zaubernapp.viewmodels.ProductViewModel
import com.example.zaubernapp.viewmodels.ProductViewModelFactory
import java.util.UUID

@Composable
fun ProductScreen(
    productId: UUID
) {
    val viewModel: ProductViewModel = viewModel(factory = ProductViewModelFactory(productId))
    val uiState by viewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Text(text = uiState.name)
    }
}