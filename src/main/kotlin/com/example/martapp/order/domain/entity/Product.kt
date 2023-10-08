package com.example.martapp.order.domain.entity

data class Product(
    var productNo: Long? = null,
    var productName: String,
    var productPrice: Double,
)