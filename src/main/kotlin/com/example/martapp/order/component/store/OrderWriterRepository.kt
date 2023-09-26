package com.example.martapp.order.component.store

import com.example.martapp.order.business.model.OrderModel

interface OrderWriterRepository {
    fun save(orderModel: OrderModel): String
}