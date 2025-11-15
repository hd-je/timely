package io.github.timely.timelyapi.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "TB_USER")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_SN")
    val id: Long = 0,

    @Column(name = "USER_ID", nullable = false, length = 100)
    val userId: String,

    @Column(name = "USER_NM", nullable = false, length = 100)
    val name: String,

    @Column(name = "USER_PWD", length = 100)
    val password: String? = null,

    @Column(name = "PHONE", length = 20)
    val phone: String? = null,

    @Column(name = "EMAIL", length = 100)
    val email: String? = null,

    @Column(name = "SNS_ID", length = 100)
    val snsId: String? = null,

    @Column(name = "CREATE_ID", length = 100)
    val createId: String? = null,

    @Column(name = "CREATE_DT")
    val createDt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "UPDATE_ID", length = 100)
    val updateId: String? = null,

    @Column(name = "UPDATE_DT")
    val updateDt: LocalDateTime = LocalDateTime.now()
)