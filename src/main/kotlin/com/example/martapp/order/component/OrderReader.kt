package com.example.martapp.order.component

import com.example.martapp.order.business.model.OrderModel
import com.example.martapp.order.component.store.OrderReaderRepository
import com.example.martapp.order.router.dto.OrderResponseDto
import org.springframework.stereotype.Component

@Component
class OrderReader(
    private val orderReaderRepository: OrderReaderRepository
) {
    fun getOrder(id: Long): OrderModel {
        return orderReaderRepository.findById(id)
    }
}