package com.example.martapp.user.persistence.repository.command

import com.example.martapp.user.component.store.UserWriterRepository
import com.example.martapp.user.persistence.entity.User
import com.example.martapp.user.persistence.repository.UserJpaRepository
import org.springframework.stereotype.Repository

@Repository
class UserCommand(
    private val jpaRepository: UserJpaRepository
) : UserWriterRepository {

    override fun save(user: User): String {
        jpaRepository.save(user)
        return "Success"
    }
}