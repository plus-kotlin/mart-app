package com.example.martapp.order.api

import com.example.martapp.order.domain.command.OrderCommand
import com.example.martapp.order.api.request.OrderRegisterRequest
import com.example.martapp.order.api.response.OrderResponse
import com.example.martapp.order.domain.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderService: OrderService,
) {

    @PostMapping("/order/register")
    fun orderRegister(
        @RequestBody orderRegisterRequest: OrderRegisterRequest,
    ): OrderResponse {
        val order = orderService.orderRegister(
            OrderCommand.Register.of(
                orderRegisterRequest.ordererName,
                orderRegisterRequest.ordererAddress,
                orderRegisterRequest.totalPrice,
            )
        )

        return OrderResponse(
            orderNo = order.orderNo,
            ordererName = order.ordererName,
            ordererAddress = order.ordererAddress,
            totalPrice = order.totalPrice,
        )
    }
}