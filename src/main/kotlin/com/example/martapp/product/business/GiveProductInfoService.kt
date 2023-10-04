package com.example.martapp.product.business

import com.example.martapp.product.business.model.ProductModel
import com.example.martapp.product.business.port.ProductRepository
import com.example.martapp.product.component.ProductNameChecker
import com.example.martapp.product.persistence.entity.Product
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class GiveProductInfoService (
    private val productRepository: ProductRepository,
    private val nameChecker: ProductNameChecker
){
    @Transactional(readOnly = true)
    fun getProductInfo(productNumber: String): ProductModel {
        val product: Product = productRepository.findByProductNumber(productNumber)
        nameChecker.isNameValid(product.name)
        return ProductModel.of(product)
    }
}