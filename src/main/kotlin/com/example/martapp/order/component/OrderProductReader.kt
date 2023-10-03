package com.example.martapp.order.component

import com.example.martapp.order.business.model.OrderProductModel
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class OrderProductReader(
    private val orderReader: OrderReader,
    private val productReader: ProductReader
) {

    @Transactional // 필수는 아니지만 예제를 위해 추가
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