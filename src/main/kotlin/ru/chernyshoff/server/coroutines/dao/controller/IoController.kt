package ru.chernyshoff.server.coroutines.dao.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.chernyshoff.server.coroutines.service.IoService

@RestController
@RequestMapping("/server/io")
class IoController(
    private val service: IoService
) {

    @GetMapping
    suspend fun get(): String = service.get()
}