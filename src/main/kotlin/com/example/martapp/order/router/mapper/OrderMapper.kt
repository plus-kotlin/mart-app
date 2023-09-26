package com.example.martapp.order.router.mapper

import com.example.martapp.order.business.model.OrderModel
import com.example.martapp.order.router.dto.OrderRequestDto

class OrderMapper {
    companion object {
        fun orderDtoToOrderModel(dto: OrderRequestDto): OrderModel = OrderModel(
            ordererName = dto.ordererName
        )
    }
}