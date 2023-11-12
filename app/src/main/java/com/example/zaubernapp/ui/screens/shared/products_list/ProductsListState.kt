package com.example.zaubernapp.ui.screens.shared.products_list

import com.example.zaubernapp.ui.screens.product.ProductState
import java.util.UUID

data class ProductsListState (
    val products: HashMap<UUID, ProductState>
)