package io.github.timely.timelyapi.menu.controller

import io.github.timely.timelyapi.menu.service.MenuService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/menus")
class MenuController(
    private val menuService: MenuService
) {

    @GetMapping("/{menuSn}")
    fun getMenu(@PathVariable menuSn: Long) =
        menuService.getMenu(menuSn)

    @GetMapping
    fun getMenuList() = menuService.getMenuList()

    @GetMapping("/tree")
    fun getMenuTree() = menuService.getMenuTree()
}