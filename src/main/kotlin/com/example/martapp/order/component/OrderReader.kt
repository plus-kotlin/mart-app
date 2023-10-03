package com.example.martapp.order.component

import com.example.martapp.order.component.store.OrderReaderRepository
import com.example.martapp.order.persistence.entity.Order
import org.springframework.stereotype.Component

@Component
class OrderReader(
    private val orderReaderRepository: OrderReaderRepository
) {
    fun getOrder(id: Long): Order {
        return orderReaderRepository.findById(id)
    }
}