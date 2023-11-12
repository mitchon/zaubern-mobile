package com.example.zaubernapp.repositories

import com.example.zaubernapp.states.ProductState
import java.util.UUID

interface ProductsRepositoryInterface {
    fun getAll(): HashMap<UUID, ProductState>
    fun getById(id: UUID): ProductState?
}