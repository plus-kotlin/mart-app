package com.example.martapp.product.persistence

import com.example.martapp.product.persistence.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductJpaRepository : JpaRepository<Product, Long> {
    fun findByProductNumber(productNumbers: String?): Product
}