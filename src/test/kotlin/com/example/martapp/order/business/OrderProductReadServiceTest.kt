package com.example.martapp.order.business

import com.example.martapp.order.business.model.OrderProductModel
import com.example.martapp.order.component.OrderProductReader
import com.example.martapp.order.router.dto.OrderProductResponseDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.anyLong
import org.mockito.Mockito.`when`
import org.mockito.kotlin.mock

class OrderProductReadServiceTest {

    @Test
    fun `주문 상품 조회 서비스 (getOrderProduct)`() {
        // Given
        val givenOrderProductResponseDto = OrderProductResponseDto(
            orderId = 1L,
            ordererName = "주문 이름",
            productId = 1L,
            productName = "상품 이름",
            productPrice = 10000.0
        )

        val orderProductReader: OrderProductReader = mock()
        `when`(orderProductReader.getOrderProduct(anyLong(), anyLong())).thenReturn(
            OrderProductModel(
                orderId = 1L,
                ordererName = givenOrderProductResponseDto.ordererName,
                productId = givenOrderProductResponseDto.productId,
                productName = givenOrderProductResponseDto.productName,
                productPrice = givenOrderProductResponseDto.productPrice
            )
        )
        val orderProductReadService = OrderProductReadService(orderProductReader)
        givenOrderProductResponseDto.productPrice = 20000.0

        // When
        val orderProductResponseDto = orderProductReadService.getOrderProduct(
            givenOrderProductResponseDto.orderId,
            givenOrderProductResponseDto.productId
        )

        // Then
        assertThat(orderProductResponseDto).isEqualTo(givenOrderProductResponseDto)
    }
}