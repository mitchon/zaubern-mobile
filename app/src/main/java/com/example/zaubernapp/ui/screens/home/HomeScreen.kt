package com.example.zaubernapp.ui.screens.home

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zaubernapp.ui.screens.shared.products_list.ProductItemView
import com.example.zaubernapp.ui.screens.shared.products_list.ProductsListScreen
import com.example.zaubernapp.ui.screens.shared.products_list.ProductsListViewModel
import com.example.zaubernapp.ui.theme.onestFamily
import java.util.UUID

@Composable
fun HomeScreen(
    onProductClicked: (UUID) -> Unit
) {
    val viewModel: ProductsListViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val productsList = remember { uiState.products.values.toList() }

    fun LazyListScope.content() {
        item {
            Text(
                text = "Хиты продаж",
                style = TextStyle(
                    fontSize = 25.sp,
                    lineHeight = 22.sp,
                    fontFamily = onestFamily,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,)
            )
        }
        items(
            count = productsList.size,
            key = {
                productsList[it].id }
        ) {
            ProductItemView(productsList[it], onProductClicked)
        }
    }

    ProductsListScreen { content() }
}