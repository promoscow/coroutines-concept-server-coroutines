package ru.chernyshoff.server.coroutines.service

interface IoService {

    suspend fun trace(traceId: String): String
}