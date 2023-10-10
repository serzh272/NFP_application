package ru.serzh272.common.constants

import kotlinx.coroutines.CoroutineDispatcher

interface NfpCoroutineDispatchers {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
}
