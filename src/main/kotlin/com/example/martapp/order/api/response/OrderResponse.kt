package com.example.martapp.order.api.response

data class OrderResponse(
    val orderNo: Long?,
    val ordererName: String,
    val ordererAddress: String,
    val totalPrice: Double,
)
