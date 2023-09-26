package com.example.martapp.order.router

import com.example.martapp.order.business.OrderProductReadService
import com.example.martapp.order.business.OrderReadService
import com.example.martapp.order.business.OrderSaveService
import com.example.martapp.order.router.dto.OrderProductResponseDto
import com.example.martapp.order.router.dto.OrderRequestDto
import com.example.martapp.order.router.dto.OrderResponseDto
import com.example.martapp.order.router.mapper.OrderMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderRouter(
    private val orderReadService: OrderReadService,
    private val orderSaveService: OrderSaveService,
    private val orderProductReadService: OrderProductReadService
) {
    @GetMapping("/order/{id}")
    fun getOrder(@PathVariable id: Long): OrderResponseDto = orderReadService.getOrder(id)

    @PostMapping("/order")
    fun saveOrder(@RequestBody requestDto: OrderRequestDto): String = orderSaveService.saveOrder(OrderMapper.orderDtoToOrderModel(requestDto))

    @GetMapping("/order/{orderId}/product/{productId}")
    fun getOrderProduct(@PathVariable orderId: Long, @PathVariable productId: Long): OrderProductResponseDto = orderProductReadService.getOrderProduct(orderId, productId)
}