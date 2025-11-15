package io.github.timely.timelyapi.user.controller

data class UserSignupResponse(
    val userSn: Long,
    val userId: String,
    val name: String
)
