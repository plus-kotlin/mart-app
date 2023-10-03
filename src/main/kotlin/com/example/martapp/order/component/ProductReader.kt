package com.example.martapp.order.component

import com.example.martapp.order.business.model.ProductModel
import com.example.martapp.order.component.store.ProductReaderRepository
import com.example.martapp.order.persistence.entity.Product
import org.springframework.stereotype.Component

@Component
class ProductReader() {
    object productReaderRepository : ProductReaderRepository {
        override fun findById(id: Long): Product {
            return Product(id = id, name = "상품 이름", price = 10000.0)
        }
    }

    fun getProduct(id: Long): ProductModel {
        val product = productReaderRepository.findById(id)
        return ProductModel(
            productId = product.id,
            productName = product.name,
            productPrice = product.price
        )
    }
}