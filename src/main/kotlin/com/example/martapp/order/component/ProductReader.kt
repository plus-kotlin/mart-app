package com.example.martapp.order.component

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

    fun getProduct(id: Long): Product {
        return productReaderRepository.findById(id)
    }
}