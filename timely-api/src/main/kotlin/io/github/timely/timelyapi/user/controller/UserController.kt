package io.github.timely.timelyapi.user.controller

import io.github.timely.timelyapi.user.domain.User
import io.github.timely.timelyapi.user.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun getUsers(): List<User> =
        userService.getUsers()

    @GetMapping("/{sn}")
    fun getUser(@PathVariable sn: Long): User =
        userService.getUser(sn)

    @GetMapping("/id/{userId}")
    fun getUserByUserId(@PathVariable userId: String): User =
        userService.getUserByUserId(userId)

    // 회원가입
    @PostMapping("/signup")
    fun signup(@RequestBody req: UserSignupRequest): UserSignupResponse {
        return userService.signup(req)
    }
}