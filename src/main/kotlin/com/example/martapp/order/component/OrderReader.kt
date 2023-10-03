package com.example.martapp.order.component

import com.example.martapp.order.business.model.OrderModel
import com.example.martapp.order.component.store.OrderReaderRepository
import com.example.martapp.order.persistence.entity.Order
import org.springframework.stereotype.Component

@Component
class OrderReader(
    private val orderReaderRepository: OrderReaderRepository
) {
    fun getOrder(id: Long): OrderModel {
        val order = orderReaderRepository.findById(id)
        return OrderModel(
            id = order.id,
            ordererName = order.ordererName
        )
    }
}