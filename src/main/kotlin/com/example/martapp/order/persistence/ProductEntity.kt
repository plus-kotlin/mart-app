package com.example.martapp.order.persistence

import jakarta.persistence.*
import lombok.NoArgsConstructor

@Entity
@Table
@NoArgsConstructor
class ProductEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "name")
    var productName: String,
    @Column(name = "price")
    var productPrice: Double,
)