package com.example.martapp.order.business

import com.example.martapp.order.component.OrderProductReader
import com.example.martapp.order.router.dto.OrderProductResponseDto
import org.springframework.stereotype.Service

@Service
class OrderProductReadService(
    private val orderProductReader: OrderProductReader
) {
    fun getOrderProduct(orderId: Long, productId: Long): OrderProductResponseDto {
        val model = orderProductReader.getOrderProduct(orderId, productId)

        model.productPrice *= 2

        return OrderProductResponseDto(
            orderId = model.orderId,
            ordererName = model.ordererName,
            productId = model.productId,
            productName = model.productName,
            productPrice = model.productPrice
        )
    }
}