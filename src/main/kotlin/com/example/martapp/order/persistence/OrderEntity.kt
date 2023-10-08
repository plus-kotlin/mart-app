package com.example.martapp.order.persistence

import jakarta.persistence.*
import lombok.NoArgsConstructor

@Entity
@Table(name = "orders")
@NoArgsConstructor
class OrderEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "username")
    var ordererName: String,
    @Column(name = "address")
    var ordererAddress: String,
    @Column(name = "totalPrice")
    var totalPrice: Double
) {
    init {
        if (ordererName.isBlank()) {
            throw IllegalArgumentException("Not Blank ordererName")
        }
    }
}