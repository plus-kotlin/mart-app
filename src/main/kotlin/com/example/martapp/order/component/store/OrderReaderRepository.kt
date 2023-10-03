package com.example.martapp.order.component.store

import com.example.martapp.order.persistence.entity.Order

interface OrderReaderRepository {
    fun findById(id: Long): Order
}