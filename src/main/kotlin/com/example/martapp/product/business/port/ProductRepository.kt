package com.example.martapp.product.business.port

import com.example.martapp.product.persistence.entity.Product

interface ProductRepository {
    fun findByProductNumber(productNumbers: String?): Product
}