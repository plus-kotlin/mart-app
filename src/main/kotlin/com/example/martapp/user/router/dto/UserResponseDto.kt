package com.example.martapp.user.router.dto

data class UserResponseDto(
    val id: Long,
    val userName: String,
    val password: String,
    val email: String
)