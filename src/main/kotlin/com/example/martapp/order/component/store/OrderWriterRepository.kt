package com.example.martapp.order.component.store

import com.example.martapp.order.persistence.entity.Order

interface OrderWriterRepository {
    fun save(order: Order): String
}