package com.example.martapp.user.component.store

import com.example.martapp.user.persistence.entity.User

interface UserReaderRepository {

    fun findById(id: Long): User
}