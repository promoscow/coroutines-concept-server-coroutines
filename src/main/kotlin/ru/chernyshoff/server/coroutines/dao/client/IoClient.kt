package ru.chernyshoff.server.coroutines.dao.client

interface IoClient {

    suspend fun trace(traceId: String): String
}