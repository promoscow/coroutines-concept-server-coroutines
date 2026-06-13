package ru.chernyshoff.server.coroutines.dao.client.impl

import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import ru.chernyshoff.server.coroutines.dao.client.IoClient

@Component
class IoClientImpl(
    private val client: WebClient,
    @Value($$"${app.io.host}") private val ioHost: String
) : IoClient {

    override suspend fun trace(traceId: String): String =
        client
            .get()
            .uri("$ioHost/api/io/trace/{traceId}", traceId)
            .retrieve()
            .bodyToMono(String::class.java)
            .awaitSingle()
}