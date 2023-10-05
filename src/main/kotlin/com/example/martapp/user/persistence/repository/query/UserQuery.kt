package com.example.martapp.user.persistence.repository.query

import com.example.martapp.user.persistence.entity.QUser
import com.example.martapp.user.persistence.entity.User
import com.example.martapp.user.component.store.UserReaderRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class UserQuery(
    private val query: JPAQueryFactory,
) : UserReaderRepository {

    private val qUser: QUser = QUser("user")
    override fun findById(id: Long): User {
        return query.selectFrom(qUser).where(qUser.id.eq(id)).fetchOne() ?: throw NullPointerException("Not Found User")
    }

}