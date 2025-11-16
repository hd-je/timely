package io.github.timely.timelyapi.menu.service

import io.github.timely.timelyapi.menu.dto.MenuDto
import io.github.timely.timelyapi.menu.model.Menu
import io.github.timely.timelyapi.menu.repository.MenuRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MenuService(
    private val menuRepository: MenuRepository
) {

    @Transactional(readOnly = true)
    fun getMenu(menuSn: Long): MenuDto.Response {
        val menu = menuRepository.findById(menuSn)
            .orElseThrow { IllegalArgumentException("Menu not found") }

        return MenuDto.Response(
            menuSn = menu.menuSn!!,
            menuNm = menu.menuNm,
            menuUrl = menu.menuUrl,
            upMenuSn = menu.upMenuSn,
            menuLvl = menu.menuLvl,
            sortOrd = menu.sortOrd,
            useYn = menu.useYn,
            createDt = menu.createDt,
            updateDt = menu.updateDt
        )
    }

    @Transactional(readOnly = true)
    fun getMenuList(): List<MenuDto.SimpleResponse> {
        return menuRepository.findAllByOrderBySortOrdAsc()
            .map { MenuDto.SimpleResponse(it.menuSn!!, it.menuNm, it.menuUrl) }
    }

    @Transactional(readOnly = true)
    fun getMenuTree(): List<MenuDto.TreeResponse> {
        val rootMenus = menuRepository.findAllByUpMenuSnOrderBySortOrdAsc(null)

        return rootMenus.map { toTree(it) }
    }

    private fun toTree(menu: Menu): MenuDto.TreeResponse {
        val children = menuRepository
            .findAllByUpMenuSnOrderBySortOrdAsc(menu.menuSn)
            .map { child -> toTree(child) }

        return MenuDto.TreeResponse(
            menuSn = menu.menuSn!!,
            menuNm = menu.menuNm,
            menuUrl = menu.menuUrl,
            children = children
        )
    }
}