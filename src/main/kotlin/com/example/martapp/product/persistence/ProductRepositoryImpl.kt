package com.example.martapp.product.persistence

import com.example.martapp.product.business.port.ProductRepository
import com.example.martapp.product.persistence.entity.Product
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryImpl(
    private val productJpaRepository: ProductJpaRepository
) : ProductRepository{
    override fun findByProductNumber(productNumber: String?): Product {
        return productJpaRepository.findByProductNumber(productNumber);
    }

}
