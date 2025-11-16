package io.github.timely.timelyapi.menu.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "tb_menu")
class Menu (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_SN")
    val menuSn: Long? = null,

    @Column(name = "MENU_NM", nullable = false, length = 100)
    var menuNm: String,

    @Column(name = "MENU_URL")
    var menuUrl: String? = null,

    @Column(name = "UP_MENU_SN")
    var upMenuSn: Long? = null,

    @Column(name = "MENU_LVL", nullable = false)
    var menuLvl: Int,

    @Column(name = "SORT_ORD", nullable = false)
    var sortOrd: Int,

    @Column(name = "USE_YN", nullable = false, columnDefinition = "char(1)")
    var useYn: String,

    @Column(name = "CREATE_ID")
    var createId: String? = null,

    @Column(name = "CREATE_DT", insertable = false, updatable = false)
    var createDt: LocalDateTime? = null,

    @Column(name = "UPDATE_ID")
    var updateId: String? = null,

    @Column(name = "UPDATE_DT")
    var updateDt: LocalDateTime? = null
)