package com.example.martapp.order.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.NoArgsConstructor

@Entity
@Table(name = "orders")
@NoArgsConstructor
class OrderEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(name = "username")
    var ordererName: String,
    @Column(name = "address")
    var ordererAddress: String,
    @Column(name = "totalPrice")
    var totalPrice: Double,
)