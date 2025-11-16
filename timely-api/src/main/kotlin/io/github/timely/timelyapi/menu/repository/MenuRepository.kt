package io.github.timely.timelyapi.menu.repository

import io.github.timely.timelyapi.menu.dto.MenuDto
import io.github.timely.timelyapi.menu.model.Menu
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MenuRepository : JpaRepository<Menu, Long> {

    fun findAllByOrderBySortOrdAsc(): List<Menu>

    fun findAllByUpMenuSnOrderBySortOrdAsc(upMenuSn: Long?): List<Menu>
}