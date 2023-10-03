package com.example.martapp.order.component

import com.example.martapp.order.business.model.OrderModel
import com.example.martapp.order.business.model.OrderProductModel
import com.example.martapp.order.business.model.ProductModel
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.Mockito
import org.mockito.kotlin.mock

class OrderProductReaderTest {

    @Test
    fun `주문 상품 조회(getOrderProduct)`() {
        // Given
        val givenOrderProductModel = OrderProductModel(
            orderId = 1L,
            ordererName = "주문 이름",
            productId = 1L,
            productName = "상품 이름",
            productPrice = 10000.0
        )
        val orderReader: OrderReader = mock()
        val productReader: ProductReader = mock()

        Mockito.`when`(orderReader.getOrder(anyLong())).thenReturn(
            OrderModel(
                id = givenOrderProductModel.orderId,
                ordererName = givenOrderProductModel.ordererName
            )
        )

        Mockito.`when`(productReader.getProduct(anyLong())).thenReturn(
            ProductModel(
                productId = givenOrderProductModel.productId,
                productName = givenOrderProductModel.productName,
                productPrice = givenOrderProductModel.productPrice
            )
        )

        val orderProductReader = OrderProductReader(orderReader, productReader)

        // When
        val orderProductModel = orderProductReader.getOrderProduct(
            givenOrderProductModel.orderId,
            givenOrderProductModel.productId
        )

        // Then
        assertThat(orderProductModel).isEqualTo(givenOrderProductModel)
    }
}