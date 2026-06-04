package ru.chernyshoff.server.coroutines.dao.client.impl

import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import ru.chernyshoff.server.coroutines.dao.client.IoClient

@Component
class IoClientImpl(
    private val client: WebClient
) : IoClient {

    override suspend fun get(taskId: String): String =
        client
            .get()
            .uri("/api/io/task/{taskId}", taskId)
            .retrieve()
            .bodyToMono(String::class.java)
            .awaitSingle()

}