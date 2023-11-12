package com.example.zaubernapp.ui.screens.product

import java.util.UUID

data class ProductState (
    val id: UUID,
    val name: String,
    val description: String,
    val price: Int,
    val beforeSale: Int? = null
)