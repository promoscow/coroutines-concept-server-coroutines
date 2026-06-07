package ru.chernyshoff.server.coroutines.service.impl

import org.apache.commons.lang3.RandomStringUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import ru.chernyshoff.server.coroutines.dao.client.IoClient
import ru.chernyshoff.server.coroutines.service.IoService

@Service
class IoServiceImpl(
    private val client: IoClient,
    @Value($$"${app.service-prefix}") private val servicePrefix: String
) : IoService {

    override suspend fun trace(traceId: String): String =
        "${servicePrefix}.${RandomStringUtils.secure().nextAlphanumeric(6)}"
            .let { client.trace("$traceId-$it") }
}