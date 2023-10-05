package com.example.martapp.user.component

import com.example.martapp.user.business.model.UserModel
import com.example.martapp.user.component.store.UserWriterRepository
import com.example.martapp.user.persistence.entity.User
import org.springframework.stereotype.Component

@Component
class UserWriter(
    private val userWriterRepository: UserWriterRepository
) {
    fun saveUser(userModel: UserModel): String {
        // Order 에 저장될 때의 규칙 선언
        return userWriterRepository.save(
            User(
                username = userModel.username,
                password = userModel.password,
                email = userModel.email
            )
        )
    }
}