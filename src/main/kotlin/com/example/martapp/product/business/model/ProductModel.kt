package com.example.martapp.product.business.model

import com.example.martapp.product.persistence.entity.Product


data class ProductModel(
    val id: Long,
    val productNumber: String,
    val name: String,
    val price: Int
) {
    companion object {
        fun of(product: Product): ProductModel {
            return ProductModel(
                id = product.id,
                productNumber = product.productNumber,
                name = product.name,
                price = product.price
            )
        }
    }
}
