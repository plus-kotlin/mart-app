package com.example.martapp.order.persistence.entity

import jakarta.persistence.*
import lombok.NoArgsConstructor

@Entity
@Table(name = "product")
@NoArgsConstructor
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,
    @Column(name = "productName")
    var name: String,
    @Column(name = "price")
    var price: Double
)