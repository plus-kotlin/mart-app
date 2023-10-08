package com.example.martapp.order.domain

import com.example.martapp.order.domain.command.OrderCommand
import com.example.martapp.order.domain.entity.Order
import com.example.martapp.order.domain.repositorty.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository,
) {
    fun orderRegister(register: OrderCommand.Register): Order {
        return orderRepository.saveOrder(
            Order(
                ordererName = register.ordererName,
                ordererAddress = register.ordererAddress,
                totalPrice = register.totalPrice
            )
        )
    }
}
