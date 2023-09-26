package com.example.martapp.order.router.dto

data class OrderProductResponseDto(
    val orderId: Long,
    val ordererName: String,
    val productId: Long,
    val productName: String,
    val productPrice: Double
)
