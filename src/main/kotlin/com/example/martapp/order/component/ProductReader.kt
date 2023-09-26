package com.example.martapp.order.component

import com.example.martapp.order.business.model.ProductModel
import com.example.martapp.order.component.store.ProductReaderRepository
import org.springframework.stereotype.Component

@Component
class ProductReader() {
    object productReaderRepository: ProductReaderRepository{
        override fun findById(id: Long): ProductModel {
            return ProductModel(productId = id, productName = "상품 이름", productPrice = 1000.0)
        }
    }
    fun getProduct(id: Long): ProductModel {
        return productReaderRepository.findById(id)
    }
}