package com.example.martapp.user.router

import com.example.martapp.user.business.UserSaveService
import com.example.martapp.user.router.dto.UserRequestDto
import com.example.martapp.user.router.mapper.UserMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserRouter(
    private val userSaveService: UserSaveService
) {
    @PostMapping("/user")
    fun saveUser(@RequestBody requestDto: UserRequestDto): String =
        userSaveService.saveUser(UserMapper.userDtoModel(requestDto))
}