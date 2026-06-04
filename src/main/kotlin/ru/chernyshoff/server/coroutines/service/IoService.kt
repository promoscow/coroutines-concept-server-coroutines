package ru.chernyshoff.server.coroutines.service

interface IoService {

    suspend fun get(): String
}