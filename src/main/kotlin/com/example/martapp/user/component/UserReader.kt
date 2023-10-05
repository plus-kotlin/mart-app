package com.example.martapp.user.component

import com.example.martapp.user.business.model.UserModel
import com.example.martapp.user.component.store.UserReaderRepository
import org.springframework.stereotype.Component

@Component
class UserReader(
    private val userReaderRepository: UserReaderRepository
) {
    fun getUser(id: Long): UserModel {
        val user = userReaderRepository.findById(id)
        return UserModel(
            username = user.username,
            password = user.password,
            email = user.email
        )
    }
}