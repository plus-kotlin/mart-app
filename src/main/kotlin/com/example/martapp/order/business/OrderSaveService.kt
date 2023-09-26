package com.example.martapp.order.business

import com.example.martapp.order.business.model.OrderModel
import com.example.martapp.order.component.OrderReader
import com.example.martapp.order.component.OrderWriter
import com.example.martapp.order.router.dto.OrderResponseDto
import org.springframework.stereotype.Service

@Service
class OrderSaveService(
    private val orderWriter: OrderWriter
) {
    fun saveOrder(orderModel: OrderModel): String = orderWriter.saveOrder(orderModel)
}