package com.example.martapp.user.business

import com.example.martapp.user.component.UserReader
import com.example.martapp.user.router.dto.UserResponseDto
import org.springframework.stereotype.Service

@Service
class UserReadService(
    private val userReader: UserReader
) {
    fun getUser(id: Long): UserResponseDto {
        val userModel = userReader.getUser(id)
        return UserResponseDto(
            id = id,
            userName = userModel.username,
            password = userModel.password,
            email = userModel.email
        )
    }
}