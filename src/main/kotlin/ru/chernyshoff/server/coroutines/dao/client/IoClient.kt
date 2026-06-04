package ru.chernyshoff.server.coroutines.dao.client

interface IoClient {

    suspend fun get(taskId: String): String
}