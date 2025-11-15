package io.github.timely.timelyapi.user.repository

import io.github.timely.timelyapi.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByUserId(userId: String): User?
}