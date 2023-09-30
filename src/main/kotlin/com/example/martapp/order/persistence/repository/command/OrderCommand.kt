package com.example.martapp.order.persistence.repository.command

import com.example.martapp.order.business.model.OrderModel
import com.example.martapp.order.component.store.OrderWriterRepository
import com.example.martapp.order.persistence.entity.Order
import com.example.martapp.order.persistence.repository.OrderJpaRepository
import org.springframework.stereotype.Repository

@Repository
class OrderCommand(
    private val jpaRepository: OrderJpaRepository
) : OrderWriterRepository {
    override fun save(orderModel: OrderModel): String {
        jpaRepository.save(
            Order(
                ordererName = orderModel.ordererName
            )
        )
        return "Success"
    }
}