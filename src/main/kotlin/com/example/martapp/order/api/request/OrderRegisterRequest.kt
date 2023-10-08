package com.example.martapp.order.api.request

data class OrderRegisterRequest(
    val ordererName: String,
    val ordererAddress: String,
    val totalPrice: Double,
)
