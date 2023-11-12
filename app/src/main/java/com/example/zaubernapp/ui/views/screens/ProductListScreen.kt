package com.example.zaubernapp.ui.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zaubernapp.ui.theme.onestFamily
import com.example.zaubernapp.ui.views.ProductItemView
import com.example.zaubernapp.viewmodels.ProductsListViewModel
import java.util.UUID

@Composable
fun ProductsListScreen(
    onProductClicked: (UUID) -> Unit,
) {
    val viewModel: ProductsListViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
    ) {
        val productsList = remember { uiState.products.values.toList() }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            item {
                Text(
                    text = "Хиты продаж",
                    style = TextStyle(
                        fontSize = 25.sp,
                        lineHeight = 22.sp,
                        fontFamily = onestFamily,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                )
            }
            items(
                count = productsList.size,
                key = {
                    productsList[it].id
                },
            ) {
                ProductItemView(productsList[it], onProductClicked)
            }
        }
    }
}