package com.example.martapp.order.domain.entity

data class Order(
    var orderNo: Long? = null,
    var ordererName: String,
    var ordererAddress: String,
    var totalPrice: Double,
)