package ru.chernyshoff.server.coroutines.service.impl

import org.springframework.stereotype.Service
import ru.chernyshoff.server.coroutines.dao.client.IoClient
import ru.chernyshoff.server.coroutines.service.IoService

@Service
class IoServiceImpl(
    private val client: IoClient
) : IoService {

    override suspend fun get(taskId: String): String = client.get(taskId)
}