package io.github.timely.timelyapi.user.controller

data class UserSignupRequest(
    val userId: String,
    val name: String,
    val password: String,
    val phone: String? = null,
    val email: String? = null,
    val snsId: String? = null,
    val createId: String? = null
)