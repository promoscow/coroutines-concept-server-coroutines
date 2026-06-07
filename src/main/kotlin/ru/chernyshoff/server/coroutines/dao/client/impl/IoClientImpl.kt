package ru.chernyshoff.server.coroutines.dao.client.impl

import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import ru.chernyshoff.server.coroutines.dao.client.IoClient

@Component
class IoClientImpl(
    private val client: WebClient
) : IoClient {

    override suspend fun trace(traceId: String): String =
        client
            .get()
            .uri("http://io:8021/api/io/trace/{traceId}", traceId)
            .retrieve()
            .bodyToMono(String::class.java)
            .awaitSingle()
}