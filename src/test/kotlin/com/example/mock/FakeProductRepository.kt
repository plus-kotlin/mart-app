package com.example.mock

import com.example.martapp.product.business.port.ProductRepository
import com.example.martapp.product.persistence.entity.Product

class FakeProductRepository : ProductRepository {
    private val products = mutableMapOf<String, Product>()

    override fun findByProductNumber(productNumber: String?): Product {
        return products[productNumber] ?: throw RuntimeException("해당 상품을 찾을 수 없습니다!")
    }

    fun addProduct(product: Product) {
        products[product.productNumber] = product
    }
}
