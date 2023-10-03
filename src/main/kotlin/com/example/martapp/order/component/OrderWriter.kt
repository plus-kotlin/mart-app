package com.example.martapp.order.component

import com.example.martapp.order.business.model.OrderModel
import com.example.martapp.order.component.store.OrderWriterRepository
import com.example.martapp.order.persistence.entity.Order
import org.springframework.stereotype.Component

@Component
class OrderWriter(
    private val orderWriterRepository: OrderWriterRepository
) {
    fun saveOrder(orderModel: OrderModel): String {
        // Order 에 저장될 때의 규칙 선언
        return orderWriterRepository.save(
            Order(
                id = orderModel.id,
                ordererName = orderModel.ordererName
            )
        )
    }
}