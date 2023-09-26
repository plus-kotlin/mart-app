package com.example.martapp.order.persistence.repository.query

import com.example.martapp.order.business.model.OrderModel
import com.example.martapp.order.component.store.OrderReaderRepository
import com.example.martapp.order.persistence.entity.Order
import com.example.martapp.order.persistence.entity.QOrder
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class OrderQuery(
    private val query: JPAQueryFactory,
) : OrderReaderRepository {

    private val qOrder: QOrder = QOrder("order")

    override fun findById(id: Long): OrderModel {
        val order = query.selectFrom(qOrder).where(qOrder.id.eq(id)).fetchOne() ?: throw NullPointerException("Not Found Order")
        return OrderModel(id = order.id, ordererName = order.ordererName)
    }
}