package com.example.martapp.order.domain.repositorty

import com.example.martapp.order.domain.entity.Order

interface OrderRepository {
    fun saveOrder(order: Order): Order
}