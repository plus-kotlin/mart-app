package com.example.martapp.order.persistence

import com.example.martapp.order.domain.entity.Order
import com.example.martapp.order.domain.repositorty.OrderRepository
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryImpl(
    private val orderJpaRepository: OrderJpaRepository,
): OrderRepository {
    override fun saveOrder(order: Order): Order {

        val saveOrder = orderJpaRepository.save(
            OrderEntity(
                ordererName = order.ordererName,
                ordererAddress = order.ordererAddress,
                totalPrice = order.totalPrice,
            )
        )

        return Order(
            orderNo =  saveOrder.id,
            ordererName = saveOrder.ordererName,
            ordererAddress = saveOrder.ordererAddress,
            totalPrice = saveOrder.totalPrice,
        )
    }
}
