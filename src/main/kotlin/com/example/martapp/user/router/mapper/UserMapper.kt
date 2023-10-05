package com.example.martapp.user.router.mapper

import com.example.martapp.user.business.model.UserModel
import com.example.martapp.user.router.dto.UserRequestDto

class UserMapper {
    companion object {
        fun userDtoModel(dto: UserRequestDto): UserModel = UserModel(
            username = dto.userName,
            password = dto.password,
            email = dto.email
        )
    }
}