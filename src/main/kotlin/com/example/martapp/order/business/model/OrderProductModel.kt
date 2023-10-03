package com.example.martapp.order.business.model

data class OrderProductModel(
    val orderId: Long,
    val ordererName: String,
    val productId: Long,
    val productName: String,
    var productPrice: Double
)