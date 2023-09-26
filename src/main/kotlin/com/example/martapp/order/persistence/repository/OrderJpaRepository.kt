package com.example.martapp.order.persistence.repository

import com.example.martapp.order.persistence.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderJpaRepository: JpaRepository<Order, Long>