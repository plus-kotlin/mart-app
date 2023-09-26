package com.example.martapp.order.component.store

import com.example.martapp.order.business.model.OrderModel

interface OrderReaderRepository {
    fun findById(id: Long): OrderModel
}