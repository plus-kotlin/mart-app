package com.example.martapp.order.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface ProductJpaRepository: JpaRepository<ProductEntity, Long> {
}