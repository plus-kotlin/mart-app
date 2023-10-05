package com.example.martapp.shared.config.security

import com.example.martapp.user.persistence.entity.User
import com.example.martapp.user.persistence.repository.UserJpaRepository
import lombok.RequiredArgsConstructor
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@RequiredArgsConstructor
@Service
class UserDetailsServiceImpl(private val userRepository: UserJpaRepository) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user: User = userRepository.findByUsername(username)
        return UserDetailsImpl(user)
    }
}