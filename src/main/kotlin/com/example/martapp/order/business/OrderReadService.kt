package com.example.martapp.order.business

import com.example.martapp.order.business.model.OrderModel
import com.example.martapp.order.component.OrderReader
import com.example.martapp.order.component.OrderWriter
import com.example.martapp.order.router.dto.OrderResponseDto
import org.springframework.stereotype.Service

@Service
class OrderReadService(
    private val orderReader: OrderReader
) {
    fun getOrder(id: Long): OrderResponseDto {
        val orderModel =  orderReader.getOrder(id)
        return OrderResponseDto(id = orderModel.id, ordererName = orderModel.ordererName)
    }
}