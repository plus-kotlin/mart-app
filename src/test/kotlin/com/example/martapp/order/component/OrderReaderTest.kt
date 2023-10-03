package com.example.martapp.order.component

import com.example.martapp.order.business.model.OrderModel
import com.example.martapp.order.component.store.OrderReaderRepository
import com.example.martapp.order.persistence.entity.Order
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.kotlin.*

class OrderReaderTest {
    @Test
    fun `주문 조회 (getOrder)`() {
        // Given
        val givenOrder = OrderModel(
            id = 1L,
            ordererName = "주문 이름"
        )
        val orderReaderRepository: OrderReaderRepository = mock()
        `when`(orderReaderRepository.findById(anyLong())).thenReturn(
            Order(
                id = givenOrder.id,
                ordererName = "주문 이름"
            )
        )
        val orderReader = OrderReader(orderReaderRepository)

        // When
        val orderModel = orderReader.getOrder(givenOrder.id)

        // Then
        assertThat(orderModel).isEqualTo(givenOrder)
    }
}
