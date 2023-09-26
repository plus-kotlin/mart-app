package com.example.martapp.order.component

import com.example.martapp.order.business.model.OrderProductModel
import com.example.martapp.order.business.model.ProductModel
import com.example.martapp.order.component.store.OrderReaderRepository
import com.example.martapp.order.component.store.ProductReaderRepository
import org.springframework.stereotype.Component

@Component
class OrderProductReader(
    private val orderReaderRepository: OrderReaderRepository
) {
    object productReaderRepository: ProductReaderRepository {
        override fun findById(id: Long): ProductModel {
            return ProductModel(productId = id, productName = "상품 이름", productPrice = 1000.0)
        }
    }

    fun getOrderProduct(orderId: Long, productId: Long): OrderProductModel {
        val orderModel = orderReaderRepository.findById(orderId)
        val productModel = productReaderRepository.findById(productId)

        return OrderProductModel(
            orderId = orderModel.id,
            ordererName = orderModel.ordererName,
            productId = productModel.productId,
            productName = productModel.productName,
            productPrice = productModel.productPrice
        )
    }
}