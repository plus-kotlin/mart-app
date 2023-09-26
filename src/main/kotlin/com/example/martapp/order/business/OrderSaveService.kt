package com.example.martapp.order.business

import com.example.martapp.order.business.model.OrderModel
import com.example.martapp.order.component.OrderWriter
import org.springframework.stereotype.Service

@Service
class OrderSaveService(
    private val orderWriter: OrderWriter
) {
    fun saveOrder(orderModel: OrderModel): String = orderWriter.saveOrder(orderModel)
}