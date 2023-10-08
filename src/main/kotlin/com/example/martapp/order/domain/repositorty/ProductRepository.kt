package com.example.martapp.order.domain.repositorty

import com.example.martapp.order.domain.entity.Product

interface ProductRepository {
    fun saveProduct(product: Product): Product
}