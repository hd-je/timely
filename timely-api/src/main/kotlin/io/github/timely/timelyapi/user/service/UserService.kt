package io.github.timely.timelyapi.user.service

import io.github.timely.timelyapi.user.controller.UserSignupRequest
import io.github.timely.timelyapi.user.controller.UserSignupResponse
import io.github.timely.timelyapi.user.domain.User
import io.github.timely.timelyapi.user.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserService(
    private val userRepository: UserRepository
) {
    private val passwordEncoder = BCryptPasswordEncoder()

    fun getUsers(): List<User> =
        userRepository.findAll()

    fun getUser(sn: Long): User =
        userRepository.findById(sn).orElseThrow {
            IllegalArgumentException("User not found: $sn")
        }

    fun getUserByUserId(userId: String): User =
        userRepository.findByUserId(userId)
            ?: throw IllegalArgumentException("User not found: $userId")

    fun signup(req: UserSignupRequest): UserSignupResponse {
        // id 중복체크
        if (userRepository.findByUserId(req.userId) != null) {
            throw IllegalArgumentException("이미 사용 중인 아이디입니다: ${req.userId}")
        }

        // 2. 엔티티 생성
        val user = User(
            userId = req.userId,
            name = req.name,
            password = passwordEncoder.encode(req.password), // 비번 암호화
            phone = req.phone,
            email = req.email,
            snsId = req.snsId,
            createId = req.createId
        )

        // 3. 저장
        val saved = userRepository.save(user)

        return UserSignupResponse(
            userSn = saved.id,
            userId = saved.userId,
            name = saved.name
        )
    }
}