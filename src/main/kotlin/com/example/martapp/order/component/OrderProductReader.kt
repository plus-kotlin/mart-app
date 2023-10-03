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
        val order = orderReader.getOrder(orderId)
        val product = productReader.getProduct(productId)

        return OrderProductModel(
            orderId = order.id,
            ordererName = order.ordererName,
            productId = product.id,
            productName = product.name,
            productPrice = product.price
        )
    }
}