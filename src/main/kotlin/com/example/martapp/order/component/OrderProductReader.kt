package com.example.martapp.order.component

import com.example.martapp.order.business.model.OrderProductModel
import org.springframework.stereotype.Component

@Component
class OrderProductReader(
    private val orderReader: OrderReader,
    private val productReader: ProductReader
) {
    fun getOrderProduct(orderId: Long, productId: Long): OrderProductModel {
        val orderModel = orderReader.getOrder(orderId)
        val productModel = productReader.getProduct(productId)

        return OrderProductModel(
            orderId = orderModel.id,
            ordererName = orderModel.ordererName,
            productId = productModel.productId,
            productName = productModel.productName,
            productPrice = productModel.productPrice
        )
    }
}