package com.example.martapp.order.component.store

import com.example.martapp.order.persistence.entity.Product

interface ProductReaderRepository {
    fun findById(id: Long): Product
}