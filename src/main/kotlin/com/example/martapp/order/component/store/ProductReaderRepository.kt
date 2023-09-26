package com.example.martapp.order.component.store

import com.example.martapp.order.business.model.ProductModel

interface ProductReaderRepository {
    fun findById(id: Long): ProductModel
}