package com.example.martapp.user.persistence.repository

import com.example.martapp.user.persistence.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserJpaRepository : JpaRepository<User, Long> {

    @Query(
        "select u from User u where u.username = :userName"
    )
    fun findByUsername(userName: String?): User

}
