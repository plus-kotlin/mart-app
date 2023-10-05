package com.example.martapp.user.business

import com.example.martapp.user.business.model.UserModel
import com.example.martapp.user.component.UserWriter
import org.springframework.stereotype.Service

@Service
class UserSaveService(
    private val userWriter: UserWriter
) {
    fun saveUser(userModel: UserModel): String = userWriter.saveUser(userModel)
}