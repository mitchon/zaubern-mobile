package com.example.zaubernapp.repositories

import com.example.zaubernapp.ui.screens.product.ProductState
import java.util.UUID

object ProductsMockRepository: ProductsRepositoryInterface {
    private val products: HashMap<UUID, ProductState> = HashMap(
        (1..10).associate {
            val id = UUID.randomUUID()
            val product = ProductState(
                id = id,
                name = "Product $it",
                description = "Product description",
                price = 123,
                beforeSale = if (it % 3 == 0) 300 else null
            )
            id to product
        }
    )

    override fun getAll() = products
    override fun getById(id: UUID) = products[id]
}