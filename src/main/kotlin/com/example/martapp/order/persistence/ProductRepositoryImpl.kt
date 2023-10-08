package com.example.martapp.order.persistence

import com.example.martapp.order.domain.entity.Product
import com.example.martapp.order.domain.repositorty.ProductRepository

class ProductRepositoryImpl(
    private val productJpaRepository: ProductJpaRepository,
): ProductRepository {
    override fun saveProduct(product: Product): Product {
        return Product(productName = "", productPrice = 100.0)
    }
}