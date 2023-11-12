package com.example.zaubernapp.states

import java.util.UUID

data class ProductsListState (
    val products: HashMap<UUID, ProductState>
)