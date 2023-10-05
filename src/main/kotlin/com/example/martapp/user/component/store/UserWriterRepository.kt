package com.example.martapp.user.component.store

import com.example.martapp.user.persistence.entity.User

interface UserWriterRepository {
    fun save(user: User): String
}